package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsDialog implements ActionListener {

	private JDialog dialog;
	private JTextField textField;
	private ButtonGroup butGroup;
	private JSlider slider;
	private Boolean isReadyToStart = false;

	private static final String[] PLAYERTYPES = {"Mensch","KI","Netzwerk"};
	
	public SettingsDialog() {
		dialog = new JDialog();//new CustomDialog());
		Application.centreWindow(dialog);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setSize(300, 300);
		dialog.setModal(true);
		dialog.setTitle("Settings");
		dialog.setLayout(new BorderLayout(10,10));
		dialog.add(initPlayerSettings(),BorderLayout.NORTH);
		dialog.add(initSliderSettings(),BorderLayout.CENTER);
		dialog.add(initButtonBox(),BorderLayout.SOUTH);
		dialog.setVisible(true);
	}
	
	public JPanel initPlayerSettings(){
		JPanel enemy = new JPanel(true);
		butGroup = new ButtonGroup();
		enemy.setSize(450,200);
		enemy.setBorder(new BevelBorder( BevelBorder.LOWERED ));
		enemy.setLayout(new GridLayout(4, 1));
		textField = new JTextField("127.0.0.1");
		textField.setEnabled(false);
		Boolean first = true;
		for(String st: PLAYERTYPES){
			JRadioButton but = new JRadioButton(st);
			but.setSelected(first);
			first = false;
			but.addChangeListener(new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					JRadioButton but = (JRadioButton) e.getSource();
					if (but.getText()== PLAYERTYPES[2]){
						textField.setEnabled(but.isSelected());
					}
					
				}
				
			});
			butGroup.add(but);
			enemy.add(but);
		}
		enemy.add(textField);
		enemy.setVisible(true);

		return enemy;
	}
	
	public JPanel initSliderSettings(){
		JPanel sliderPanel = new JPanel();
		sliderPanel.setSize(450,50);
		sliderPanel.setLayout(new GridLayout(2, 1));
		
		slider = new JSlider(3, 10,5);
		slider.setMajorTickSpacing(2);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);    //Striche werden angezeigt
		slider.setPaintLabels(true);  //Zahlen werden nicht angezeigt
		slider.setPaintTrack(true);
		
		JLabel sliderTitel = new JLabel("Game Size");
		sliderPanel.add(sliderTitel);
		sliderPanel.add(slider);
		
		sliderPanel.setVisible(true);
		return sliderPanel;
	}
	
	public JPanel initButtonBox(){
		JPanel butBox = new JPanel();
		JButton butStart = new JButton("Start Game");
		JButton butCancel = new JButton("Cancel");
		butStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setIsReadyToStart(true);
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		butCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setIsReadyToStart(false);
				dialog.setVisible(false);
				dialog.dispose();				
			}
		});
		butBox.add(butStart);
		butBox.add(butCancel);
		
		butBox.setVisible(true);
		return butBox;
	}
	
	public int getSize(){
		return slider.getValue();
	}
	public Enumeration<AbstractButton> getGameType(){
		return butGroup.getElements();
	}
	
	public void askHostAddress() throws IOException {
		JOptionPane.showInputDialog("Enter IP address of the opponent");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Je nach Auswahl Spielmodus (Mensch, Netzwerk oder KI) setzen
		
	}

	public Boolean isReadyToStart() {
		return isReadyToStart;
	}

	public void setIsReadyToStart(Boolean isReadyToStart) {
		this.isReadyToStart = isReadyToStart;
	}

	
}
