package com.lqq.controller;

import static com.lqq.util.common.HbrConstants.MAP_DOCUMENT;
import static com.lqq.util.common.HbrConstants.PAGE_DEFAULT_SIZE;
import static com.lqq.util.common.HbrUtil.isNotEmpty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lqq.entity.Document;
import com.lqq.entity.User;
import com.lqq.service.HbrService;
import com.lqq.validator.MyFileValidator;

@Controller
public class DocumentController {

	@Autowired
	@Qualifier("myFileValidator")
	
	private MyFileValidator myFileValidator;
	@Autowired
	@Qualifier("hbrService")
	private HbrService hbrService;

	@RequestMapping("/document/documentSearchIndex")
	public String searchIndex() {
		return "manager/document/document_search";
	}

	@RequestMapping("/document/documentSearch")
	public String search(String name, Model model, Integer curPage) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (curPage == null) {
			curPage = 1;
		}
		if (isNotEmpty(name)) {
			Document document = new Document();
			document.setTitle(name);
			params.put(MAP_DOCUMENT, document);
		}
		PageHelper.startPage(curPage, PAGE_DEFAULT_SIZE);
		List<Document> list = hbrService.selectDocumentByParams(params);
		PageInfo<Document> pageInfo = new PageInfo<>(list);
		model.addAttribute("document_list", list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("name", name);
		return "manager/document/document_search";
	}

	@RequestMapping("/document/documentAddIndex")
	public String addIndx(Model model) {
		Document document = new Document();
		model.addAttribute("document", document);
		return "manager/document/document_add";
	}

	@RequestMapping("/document/documentAdd")
	public String add(@ModelAttribute Document document, Errors errors, HttpServletRequest request)
			throws Exception {
		System.out.println(document);
		myFileValidator.validate(document, errors);
		if (errors.hasErrors()) {
			return "manager/document/document_add";
		}
		System.out.println(document.getTitle());
		// 获取上传该文件路径
		String path = request.getServletContext().getRealPath("/upload/");
		// 获取上传文件名,并重命名
		String fileName = renameFile(document.getFile().getOriginalFilename());
		// 保存文件
		document.getFile().transferTo(new File(path + File.separator + fileName));
		document.setFileName(fileName);
		document.setCreateDate(new Date());
		User user = (User) request.getSession().getAttribute("user");
		document.setUser(user);
		request.setAttribute("title", "上传状态");
		if (hbrService.addDocument(document)) {
			request.setAttribute("message", "上传成功!");
			return "manager/document/document_add_result";
		} else {
			request.setAttribute("message", "上传失败!");
			return "manger/document/document_add";
		}
	}

	private String renameFile(String fileName) {
		String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		int randow = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + randow + extension;
	}

	@RequestMapping("/document/documentDownload")
	public ResponseEntity<byte[]> download(Integer id, HttpServletRequest request) throws Exception {

		Document document = hbrService.selecDocumentById(id);
		String fileName = document.getFileName();
		String path = request.getServletContext().getRealPath("/upload/");
		File file = new File(path + File.separator + fileName);
		// 创建Springframework的HttpHeader对象
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文乱码问题
		String downloadFileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
		// 通知浏览器以attachment(下载方式)打开
		headers.setContentDispositionFormData("attachment", downloadFileName);
		// application/octet-stream :二进制流(最常见的文件下载)
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 201 HttpStatus.CREATED
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	@RequestMapping("/document/documentDelete")
	public void delete(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getServletContext().getRealPath("/upload/");
		String fileName = hbrService.selecDocumentById(id).getFileName();
		File file = new File(path + File.separator + fileName);
		if (!file.exists()) {
			response.getWriter().write("NO_FILE");
		} else {
			file.delete();
			if (hbrService.deleteDocumentById(id)) {
				response.getWriter().write("OK");
			} else {
				response.getWriter().write("false");
			}
		}
	}

}
