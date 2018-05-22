package homework8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;

//JFrame 이름 = SwingWorkerApp, 
public class SwingWorkerApp extends JFrame {

	private JPanel contentPane; //가장 큰 Pane
	private JLabel lblTo; 
	private JTextField txtFrom;
	private JTextField txtTo;
	JButton btnStop;
	JButton btnStart;
	JTextArea txtArea;
	JProgressBar progressBar;
	private JScrollPane scrollPane;
	
	WorkerClass worker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingWorkerApp frame = new SwingWorkerApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingWorkerApp() {
		//create contentPane
		setTitle("Find Prime Numbers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);

		//create pnInput
		JPanel pnInput = new JPanel();
		contentPane.add(pnInput, BorderLayout.NORTH);
		pnInput.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//add lblPrime
		JLabel lblPrime = new JLabel("Find prime from");
		pnInput.add(lblPrime);

		//add txtFrom
		txtFrom = new JTextField();
		pnInput.add(txtFrom);
		txtFrom.setColumns(10);

		//create Run btn & add action
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// reset all views
				progressBar.setValue(0); // reset JProgressBar
				txtArea.setText(""); // clear JTextArea

				// get user input & check range
				int num1, num2;
				
				//input num1, num2
	            try {
	               num1 = Integer.parseInt(txtFrom.getText());
	               num2 = Integer.parseInt(txtTo.getText());
	            } catch (NumberFormatException ex) {
	               return;
	            } // end try

	            //create WorkerClass
				worker = new WorkerClass(num1,num2);
				worker.addPropertyChangeListener(new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent e) {
						// if the changed property is progress, update the progress bar
						if (e.getPropertyName().equals("progress")) {
							int newValue = (Integer) e.getNewValue();
							progressBar.setValue(newValue);
						}

					}

				});

				worker.execute();

			}
		});
		
		lblTo = new JLabel("to");
		pnInput.add(lblTo);
		
		txtTo = new JTextField();
		pnInput.add(txtTo);
		txtTo.setColumns(10);
		pnInput.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worker.stopWork();
			}
		});
		pnInput.add(btnStop);

		JPanel pnList = new JPanel();
		contentPane.add(pnList, BorderLayout.CENTER);
		SpringLayout sl_pnList = new SpringLayout();
		pnList.setLayout(sl_pnList);

		txtArea = new JTextArea();
		txtArea.setEditable(false);

		scrollPane = new JScrollPane(txtArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sl_pnList.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, pnList);
		sl_pnList.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, pnList);
		sl_pnList.putConstraint(SpringLayout.SOUTH, scrollPane, -5, SpringLayout.SOUTH, pnList);
		sl_pnList.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, pnList);

		pnList.add(scrollPane);

		JPanel pnStatus = new JPanel();
		contentPane.add(pnStatus, BorderLayout.SOUTH);
		pnStatus.setLayout(new GridLayout(0, 1, 0, 0));

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		pnStatus.add(progressBar);
	}

	//check isPrime
	 boolean isPrime(int n) {
	      if(n <= 1) {
	         return false;
	      }
	      for (int i = 2; i < n; i++) {
	         if (n % i == 0)
	            return false;
	      }
	      return true;
	   }
	
	public class WorkerClass extends SwingWorker<Integer, String> {
		int n1,n2;
		boolean stopped;

		public WorkerClass(int num1, int num2) {
			n1 = num1;
			n2 = num2;
			stopped = false;
		}

		@Override
		protected Integer doInBackground() throws Exception {
			// disable Start button and enable Cancel button
			btnStart.setEnabled(false);
			btnStop.setEnabled(true);

			int cnt = 0;
			try {
				 if (n1 < 0 || n1>n2) {//create error box
		               JOptionPane.showMessageDialog(null, "You have to re input the range numbers", "Wrong number",
		                     JOptionPane.ERROR_MESSAGE);
		               txtFrom.setText("");
		               txtTo.setText("");
		            }

				for (int i = n1; i <= n2; i++) {
					if (stopped) {
						break;
					}
					// do some complex work here
					Thread.sleep(100);

					// update the result
					cnt++;

					// update the view
					if (isPrime(i) == true) {
		                  publish("" + i);       
		               }
					setProgress((i) * 100 / (n2 - n1 +1));
				}
			} catch (InterruptedException e) {
				// update the status
			}
			return cnt;
		}

		// displays published values 없으면 내용 안보
		protected void process(List<String> publishedVals) {
			for (int i = 0; i < publishedVals.size(); i++) {
				txtArea.append(publishedVals.get(i) + "\n");
				txtArea.setCaretPosition(txtArea.getDocument().getLength());
			}
			
		} // end method process

		// code to execute when doInBackground completes
		protected void done() {
			// disable Start button and enable Cancel button
			btnStart.setEnabled(true);
			btnStop.setEnabled(false);
			int retNum = 0;
			try {
				retNum = get();
			} catch (InterruptedException ex) {
			}catch (ExecutionException ex) {
			} // end try catch
		}

		public void stopWork() {
			stopped = true;
		}

	}
}