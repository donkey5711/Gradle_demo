package com.example.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev")
public class Democontroller {

	@GetMapping("/out")
	public String out() {
		return "login";
	}

	@GetMapping("/list")
	public String result(Model model) {

		model.addAttribute("name", "donkey");
		model.addAttribute("age", 30);
		model.addAttribute("height", 170);
		return "hello";
	}

	@PostMapping("/adduser")
	public String login(HttpServletRequest request, Model model) throws NoSuchAlgorithmException {
		String userName = request.getParameter("user");
		String pass = request.getParameter("pass");
		String encodePass = request.getParameter("encodePass");
		if (userName != null && pass != null && encodePass != null && !encodePass.isEmpty() && !userName.isEmpty()
				&& !pass.isEmpty()) {
			model.addAttribute("userName", userName);
			model.addAttribute("pass", pass);
			model.addAttribute("encodePass", encodePass);
			model.addAttribute("meg", "ע��ɹ���");
			System.out.println("ǰ�˼��ܵ����룺" + encodePass);
			System.out.println("��˼��ܵ����룺" + md5Encode(pass));
		} else {
			model.addAttribute("meg", "ע��ʧ�ܣ������Ƿ���д��ȷ��");
		}

		return "message";
	}

	// MD5����
	public String md5Encode(String str) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] md5Bytes = digest.digest(str.getBytes());
		return bytesToHexString(md5Bytes);
	}

	// �ֽ���תΪʮ�������ַ���
	public String bytesToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString();
	}

}
