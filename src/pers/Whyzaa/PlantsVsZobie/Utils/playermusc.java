package pers.Whyzaa.PlantsVsZobie.Utils;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.SwingWorker;


import pers.Whyzaa.PlantsVsZobie.Config.GameState;
import pers.Whyzaa.PlantsVsZobie.MainFrame.PlantsVSZobie;

public class playermusc {
	
	public static void Play(final File  f,final boolean loop,GameState gs){
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				playermusc.playMusic(loop,f ,gs);
				return null;
			}
			
		};
		worker.execute();
	}
	public static void playMusic(boolean loop,File file, GameState gs) {
		byte[] audioData = new byte[1024];
		
		AudioInputStream ais = null;		
		SourceDataLine line = null;
		try {
			ais = AudioSystem.getAudioInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ais != null) {
			AudioFormat baseFormat = ais.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class,
					baseFormat);
			try {
				line = (SourceDataLine) AudioSystem.getLine(info);
				line.open(baseFormat);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (line == null) {
			return;
		}
		
		line.start();
		int inByte = 0;
		while (inByte != -1) {
			
			try {
								inByte = ais.read(audioData, 0, 1024);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			try {
				if (inByte > 0) {
								line.write(audioData, 0, inByte);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(gs!=PlantsVSZobie.gs){
				break;
			}
			
		}
		line.drain();
		
		line.stop();
	
		line.close();
			if (loop) {
			playMusic(loop,file,gs);
		}
	}
}
