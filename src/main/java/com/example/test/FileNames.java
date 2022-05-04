package com.example.test;

public class FileNames<ElementPosition,InputtedName,Filepath,DateEntry>
{
    private ElementPosition elementPosition;
    private InputtedName inputtedName;
    private Filepath filePath;
    private DateEntry dateEntry;

    public ElementPosition getElementPosition() {
        return elementPosition;
    }

    public void setElementPosition(ElementPosition elementPosition) {
        this.elementPosition = elementPosition;
    }

    public InputtedName getInputtedName() {
        return inputtedName;
    }

    public void setInputtedName(InputtedName inputtedName) {
        this.inputtedName = inputtedName;
    }

    public Filepath getFilePath() {
        return filePath;
    }

    public void setFilePath(Filepath filePath) {
        this.filePath = filePath;
    }

    public DateEntry getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(DateEntry dateEntry) {
        this.dateEntry = dateEntry;
    }

    public void FileInputted(ElementPosition element, InputtedName name, Filepath file, DateEntry date)
    {
        this.elementPosition=element;
        this.inputtedName=name;
        this.filePath=file;
        this.dateEntry=date;
    }














}
