package com.example.question.common;

public class BasicParams {
	private String templatePath;//模板路径
	private FileType fileType;//导出的文件类型
	private String fileName;//导出文件的名称,不带文件类型后缀
	private String savePath;//导出文件的存储位置，对应需要直接存储的方法，此案例中不用

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
}