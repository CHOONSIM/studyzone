package oop.inherit04;

public class Files {
	
	private String fileName;
	private long fileSize;
	
	

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}
	public long getFileSize() {
		return fileSize;
	}

	
//	public void fileName() {
//		System.out.println("파일이름");
//	}
//	public void fileSize() {
//		System.out.println("파일크기");
//	}
	public void execute() {
		System.out.println(fileName + "실행");
	}

}