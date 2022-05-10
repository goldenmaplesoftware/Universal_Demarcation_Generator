package com.example.test;

import javafx.scene.Scene;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WaterMarkGenerated extends Scene {
    public WaterMarkGenerated() throws IOException {
        super(new PDFWaterMarkAddedPane(),1280,720);
    }
}
