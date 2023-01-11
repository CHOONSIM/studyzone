package oop.inherit04;

public class Test01 {
	public static void main(String[] args) {
		
		Mp4 m4 = new Mp4();
		
		System.out.println("MP4");
		m4.setFileName("music");
		m4.setFileSize(0);
		m4.setSpeed(0);
		m4.execute();
		m4.forward();
		m4.rewind();
		System.out.println("-------------");
		System.out.println();
		
		Mp3 m3 = new Mp3();
		
		System.out.println("MP3");
		m3.setFileName(null);
		m3.setFileSize(0);
		m3.setDuration(0);
		m3.execute();
		m3.forward();
		m3.rewind();
		System.out.println("-------------");
		System.out.println();
		
		
		Hwp h = new Hwp();
		
		System.out.println("HWP");
		h.setFileName(null);
		h.setFileSize(0);
		h.setPageSize(0);
		h.execute();
		h.preview();
		System.out.println("-------------");
		System.out.println();
		
		
		Ppt p = new Ppt();
		
		System.out.println("PPT");
		p.setFileName(null);
		p.setFileSize(0);
		p.setPageSize(0);
		p.execute();
		p.slideShow();
		
	}

}
