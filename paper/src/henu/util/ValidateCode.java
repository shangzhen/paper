package henu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateCode
 */
@WebServlet(description = "ʹ��Servlet����ϵͳ��¼�õ�У����", urlPatterns = { "/ValidateCode" })
public class ValidateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//��֤ͼƬ�Ŀ��
	private int width=60;
	//��֤ͼƬ�ĸ߶�
	private int height=20;
	//��֤���ַ�����
	private int codeCount=4;
	private int x=0;
	//����߶�
	private int fontHeight;
	private int codeY;
	char[] codeSequence={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
	'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
	'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public ValidateCode() {
		super();
	}


	public void destroy() {
		super.destroy();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ͼ��buffer
		BufferedImage buffImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g=buffImg.createGraphics();
		//����һ���������������
		Random random=new Random();
		//��ͼ�����Ϊ��ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//�������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�����
		Font font=new Font("Fixedsys",Font.PLAIN,fontHeight);

		//��������
		g.setFont(font);

		//���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		//�������160�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
		g.setColor(Color.BLACK);
		for(int i=0;i<160;i++)
		{
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			g.drawLine(x, y, x+x1, y+y1);

		}
		//randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤
		StringBuffer randomCode=new StringBuffer();
		int red=0,green=0,blue=0;

		//�������codeCount���ֵ���֤��
		for(int i=0;i<codeCount;i++)
		{
			//�õ������������֤������
			String strRand=String.valueOf(codeSequence[random.nextInt(36)]);
			//�����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ
			red=random.nextInt(255);
			green=random.nextInt(255);
			blue=random.nextInt(255);

			//�������������ɫ����֤����Ƶ�ͼ����
			g.setColor(new Color(red,green,blue));
			g.drawString(strRand, (i+1)*x, codeY);
			//���������ĸ�����������һ��
			randomCode.append(strRand);

		}

		//����λ���ֵ���֤�뱣�浽session��
		HttpSession session=request.getSession();
		//SESSION���Ʋμ�CONSTANTS���еĶ���
		session.setAttribute(CONSTANTS.SESSION_VALIDATE_CODE, randomCode.toString());


		//��ֹͼ�񻺴�
		response.setHeader("Paragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");
		//��ͼ�������servlet�������
		ServletOutputStream sos=response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
		request.getRequestDispatcher("/login.jsp").include(request, response);
	}
	
	/**
	* ��ʼ����֤ͼƬ����
	*/
	public void init() throws ServletException
	{
		//��web.xml�л�ȡ��ʼ��Ϣ
		//���
		String strWidth=this.getInitParameter("width");
		//�߶�
		String strHeight=this.getInitParameter("height");
		//�ַ�����
		String strCodeCount=this.getInitParameter("codeCount");
		//��������Ϣת������ֵ
		try{
			if(strWidth!=null&&strWidth.length()!=0)
			{
				width=Integer.parseInt(strWidth);
			}
			if(strHeight!=null&&strHeight.length()!=0)
			{
				height=Integer.parseInt(strHeight);
			}
			if(strCodeCount!=null&strCodeCount.length()!=0)
			{
				codeCount=Integer.parseInt(strCodeCount);
			}
		}catch(NumberFormatException e){

		}
		x=width/(codeCount+1);
		fontHeight=height-2;
		codeY=height-4;
	} 
}
