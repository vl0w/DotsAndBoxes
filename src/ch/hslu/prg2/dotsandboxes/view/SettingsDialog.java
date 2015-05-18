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

import ch.hslu.prg2.dotsandboxes.GameController;
import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.ai.RandomArtificialIntelligence;
import ch.hslu.prg2.dotsandboxes.model.GameModel;
import ch.hslu.prg2.dotsandboxes.model.GameModelImpl;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public class SettingsDialog implements ActionListener {

	private JDialog dialog;
	private JTextField textField;
	private ButtonGroup butGroup;
	private JRadioButton butHuman;
	private JRadioButton butAI;
	private JRadioButton butNetwork;
	private JSlider slider;
	private Boolean isReadyToStart = false;

	private static final String PLAYER_HUMAN = "Mensch";
	private static final String PLAYER_AI = "KI";
	private static final String PLAYER_NETWORK = "Netzwerk";

	public SettingsDialog() {
		dialog = new JDialog();// new CustomDialog());
		MainWindow.centreWindow(dialog);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setSize(300, 300);
		dialog.setModal(true);
		dialog.setTitle("Settings");
		dialog.setLayout(new BorderLayout(10, 10));
		dialog.add(initPlayerSettings(), BorderLayout.NORTH);
		dialog.add(initSliderSettings(), BorderLayout.CENTER);
		dialog.add(initButtonBox(), BorderLayout.SOUTH);
		dialog.setVisible(true);
	}

	public JPanel initPlayerSettings() {
		JPanel enemy = new JPanel(true);
		butGroup = new ButtonGroup();
		enemy.setSize(450, 200);
		enemy.setBorder(new BevelBorder(BevelBorder.LOWERED));
		enemy.setLayout(new GridLayout(4, 1));
		textField = new JTextField("127.0.0.1");
		textField.setEnabled(false);
		Boolean first = true;

		butHuman = new JRadioButton(PLAYER_HUMAN);
		butHuman.setSelected(first);
		butAI = new JRadioButton(PLAYER_AI);
		butNetwork = new JRadioButton(PLAYER_NETWORK);
		butNetwork.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JRadioButton but = (JRadioButton) e.getSource();
				textField.setEnabled(but.isSelected());
			}

		});
		butGroup.add(butHuman);
		butGroup.add(butAI);
		butGroup.add(butNetwork);
		enemy.add(butHuman);
		enemy.add(butAI);
		enemy.add(butNetwork);

		enemy.add(textField);
		enemy.setVisible(true);

		return enemy;
	}

	public JPanel initSliderSettings() {
		JPanel sliderPanel = new JPanel();
		sliderPanel.setSize(450, 50);
		sliderPanel.setLayout(new GridLayout(2, 1));

		slider = new JSlider(3, 10, 5);
		slider.setMajorTickSpacing(2);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true); // Striche werden angezeigt
		slider.setPaintLabels(true); // Zahlen werden nicht angezeigt
		slider.setPaintTrack(true);

		JLabel sliderTitel = new JLabel("Game Size");
		sliderPanel.add(sliderTitel);
		sliderPanel.add(slider);

		sliderPanel.setVisible(true);
		return sliderPanel;
	}

	public JPanel initButtonBox() {
		JPanel butBox = new JPanel();
		JButton butStart = new JButton("Start Game");
		JButton butCancel = new JButton("Cancel");

		butStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow mainWindow = new MainWindow(getSize());

				GameModel model = new GameModelImpl(getSize());
				GameView view = mainWindow.getBoard();
				Player localPlayer = mainWindow.getBoard();
				Player opponent = createOpponent(model);

				GameController controller = new GameController(view, model,
						localPlayer, opponent);

				controller.start();

				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		butCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
				dialog.dispose();
				System.exit(0);
			}
		});
		butBox.add(butStart);
		butBox.add(butCancel);

		butBox.setVisible(true);
		return butBox;
	}

	private Player createOpponent(GameModel model) {
		if (butHuman.isSelected()) {
			return null; // TODO
		} else if (butAI.isSelected()) {
			return new RandomArtificialIntelligence(PlayerColor.RED, model);
		} else if (butNetwork.isSelected()) {
			return null; // TODO
		} else {
			return null;
		}
	}

	public int getSize() {
		return slider.getValue();
	}

	public Enumeration<AbstractButton> getGameType() {
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
}
