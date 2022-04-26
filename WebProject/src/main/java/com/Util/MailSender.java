package com.Util;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.Database.entity.Order;
import com.Database.entity.OrderDetail;
import com.Database.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSender {
	@Autowired
    private JavaMailSender mailSender;
	
	public void sendThankyou(User user,Order order,Collection<OrderDetail> orderDetails) throws MessagingException, UnsupportedEncodingException {
			String toAddress = user.getEmail();
			String fromAddress = "shopjavaweb@gmail.com";
			String senderName = "Shop Java Web Thank you";
			String subject = "Thank you for your Order";
			String content = "Dear [[name]],<br>"
                     + "<caption>List of Order detail</caption>"
                     + "<table>"
					 +"<thead >"
						+"<th>Tên sản phẩm</th>"
						+"<th>Số lượng</th>"
						+"<th>Tổng tiền</th>"
					+"</thead>"
					+"<tbody>";
            for(OrderDetail orderDetail : orderDetails){
                    content+= "<td>"+orderDetail.getProduct().getName()+"</td>"
                              +"<td>"+orderDetail.getQuantity()+"</td>"
                              +"<td>"+orderDetail.getTotal()+"</td>";
            }
			 content+="</tbody>"
                    +"</table>"
                    + "Thank you,<br>"
					+ "Your company name.";
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			 
			helper.setFrom(fromAddress, senderName);
			helper.setTo(toAddress);
			helper.setSubject(subject);
			 
			content = content.replace("[[name]]", user.getDisplayName());
			 
			helper.setText(content, true);
			 
			mailSender.send(message);
		}
}
