package ru.nyxale.zipdiff;

public class FileFromZip {
    public String zipFileName;
    public String fileName;
    public double size;
    public String content;
    public long lastModifiedTime;
    public long crc;

    public FileFromZip(String zipFileName, String fileName, double size, String content, long crc) {
        this.zipFileName = zipFileName;
        this.fileName = fileName;
        this.size = size;
        this.content = content;
        this.crc = crc;
    }

    public String getContent() {
        return content;
    }

    public String getFileName() {
        return fileName;
    }

    public String getZipFileName(){
        return zipFileName;
    }

    @Override
    public String toString() {
        return "FileFromZip{" +
            "zipFileName='" + zipFileName + '\'' +
            ", fileName='" + fileName + '\'' +
            ", size=" + size +
            ", content='" + content + '\'' +
            ", lastModifiedTime=" + lastModifiedTime +
            ", crc=" + crc +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileFromZip that = (FileFromZip) o;

        return crc == that.crc;
    }

    @Override
    public int hashCode() {
        return (int) (crc ^ (crc >>> 32));
    }
}

