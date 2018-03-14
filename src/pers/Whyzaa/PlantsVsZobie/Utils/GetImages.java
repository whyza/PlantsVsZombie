package pers.Whyzaa.PlantsVsZobie.Utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import pers.Whyzaa.PlantsVsZobie.Config.Config;

public class GetImages {
	public static HashMap<String, BufferedImage> IMAGES = new  HashMap<String, BufferedImage>();
	public static HashMap<String, File> AUDIO = new  HashMap<String, File>();
	public static HashMap<String, ImageIcon> GIFIMAGES = new  HashMap<String, ImageIcon>();
	static{
		URL  url  = Config.class.getResource("/images");
		try {
			File f = new File(url.toURI());
			File[] fs = f.listFiles();
			for (File file : fs) {
				if(file.getName().endsWith(".jpg") || file.getName().endsWith(".png")) {
					IMAGES.put(file.getName(), ImageIO.read(file));
				}

			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �洢gifͼƬ
	 */
	static {
		URL  gifURL  = Config.class.getResource("/images");
		try {
			File f = new File(gifURL.toURI());
			File[] fs = f.listFiles();
			for (File file : fs) {
				if(file.getName().endsWith(".gif")) {
					ImageIcon img  = new ImageIcon(file.getAbsolutePath());
					GIFIMAGES.put(file.getName(), img);
				
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static{
		URL  url  = Config.class.getResource("/mp3");
		try {
			File f = new File(url.toURI());
			File[] fs = f.listFiles();
			for (File file : fs) {
				if(file.getName().toLowerCase().endsWith("wav")) {
					AUDIO.put(file.getName(), file);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
