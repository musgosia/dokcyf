import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.Validator;
import javax.xml.bind.util.JAXBSource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.jdesktop.swingx.*;
import org.omg.CORBA.DATA_CONVERSION;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Formularz extends JFrame {

	private JPanel contentPane;
	private JTextField txtHistoriaChoroby;
	private JTextField txtPoradni;
	private JTextField poradnia;
	private JTextField txtNrKarty;
	private JTextField txtDataZarejest;
	private JTextField txtNrKsZdrowia;
	private JFormattedTextField numer_karty;
	private JTextField nr_ksiazeczki_zdrowia;
	private JTextField txtNazwisko;
	private JTextField nazwisko;
	private JTextField txtImi;
	private JTextField imie;
	private JTextField txtPe;
	private JTextField txtPesel;
	private JFormattedTextField pesel;
	private JTextField txtAdres;
	private JTextField adres;
	private JTextField txtUbezpieczony;
	private JTextField txtNieubezpieczony;
	private JSplitPane splitPane_1;
	private JRadioButton samoplacacy;
	private JRadioButton bezplatnie;
	private JTextField txtOddziaNfz;
	private JTextField txtGrupaKrwi;
	private JComboBox plec;
	private JComboBox oddzial_nfz;
	private JComboBox grupa_krwi;
	private JComboBox tn;
	private JSplitPane splitPane_2;
	private ButtonGroup rH;
	private ButtonGroup ubezp;
	private JRadioButton rhplus;
	private JRadioButton rhminus;
	private JXDatePicker picker;
	private JXDatePicker datePicker;
	private JTable table;
	private String filename, dir;
	private TyphistoriaChoroby historiaChoroby;
	private JTextField txtDataUr;
	private JPanel panel_4;
	private JPanel panel_2;
	private JPanel panel;
	private JButton btnDodajWiersz;
	private JButton btnUsuWiersz;
	private JButton btnZapiszPdf;
	private JTextField wiek;
	private JTextField txtWiek;
	private JXLabel komunikaty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formularz frame = new Formularz();
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
	public Formularz() {
		setTitle("Szpital 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JPanel panel_1 = new JPanel();

		JButton btnOtwrzPlik = new JButton("Otw\u00F3rz plik");
		JButton btnZapiszPlik = new JButton("Zapisz plik");
		JButton btnNowyPlik = new JButton("Nowy plik");
		JButton btnKasujRh = new JButton("Kasuj Rh");
		btnZapiszPdf = new JButton("Zapisz pdf");
		btnZapiszPdf.setEnabled(false);
		btnDodajWiersz = new JButton("Dodaj wiersz");
		btnUsuWiersz = new JButton("Usu\u0144 zaznaczone wiersze");

		txtHistoriaChoroby = new JTextField();
		txtHistoriaChoroby.setHorizontalAlignment(SwingConstants.CENTER);
		txtHistoriaChoroby.setEditable(false);
		txtHistoriaChoroby.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtHistoriaChoroby.setText("HISTORIA CHOROBY");
		txtHistoriaChoroby.setColumns(10);

		txtPoradni = new JTextField();
		txtPoradni.setEditable(false);
		txtPoradni.setText("PORADNIA");
		txtPoradni.setColumns(10);

		txtNrKarty = new JTextField();
		txtNrKarty.setEditable(false);
		txtNrKarty.setText("Nr karty");
		txtNrKarty.setColumns(10);

		txtDataZarejest = new JTextField();
		txtDataZarejest.setEditable(false);
		txtDataZarejest.setText("Data zarejestr.");
		txtDataZarejest.setColumns(10);

		txtNrKsZdrowia = new JTextField();
		txtNrKsZdrowia.setEditable(false);
		txtNrKsZdrowia.setText("Nr ks. zdrowia");
		txtNrKsZdrowia.setColumns(10);

		txtNazwisko = new JTextField();
		txtNazwisko.setEditable(false);
		txtNazwisko.setText("Nazwisko");
		txtNazwisko.setColumns(10);

		txtImi = new JTextField();
		txtImi.setEditable(false);
		txtImi.setText("Imi\u0119");
		txtImi.setColumns(10);

		txtPe = new JTextField();
		txtPe.setEditable(false);
		txtPe.setText("P\u0142e\u0107");
		txtPe.setColumns(10);

		txtPesel = new JTextField();
		txtPesel.setEditable(false);
		txtPesel.setText("Pesel");
		txtPesel.setColumns(10);
		txtPesel.setToolTipText("11 cyfr");

		txtAdres = new JTextField();
		txtAdres.setEditable(false);
		txtAdres.setText("Adres");
		txtAdres.setColumns(10);

		txtUbezpieczony = new JTextField();
		txtUbezpieczony.setHorizontalAlignment(SwingConstants.CENTER);
		txtUbezpieczony.setEditable(false);
		txtUbezpieczony.setText("ubezpieczony");
		txtUbezpieczony.setColumns(10);

		txtNieubezpieczony = new JTextField();
		txtNieubezpieczony.setText("nieubezpieczony");
		txtNieubezpieczony.setHorizontalAlignment(SwingConstants.CENTER);
		txtNieubezpieczony.setEditable(false);
		txtNieubezpieczony.setColumns(10);

		txtOddziaNfz = new JTextField();
		txtOddziaNfz.setEditable(false);
		txtOddziaNfz.setText("Oddzia\u0142 NFZ");
		txtOddziaNfz.setColumns(10);

		txtDataUr = new JTextField();
		txtDataUr.setText("Data urodzenia");
		txtDataUr.setEditable(false);
		txtDataUr.setColumns(10);

		txtWiek = new JTextField();
		txtWiek.setText("Wiek");
		txtWiek.setEditable(false);
		txtWiek.setColumns(10);

		txtGrupaKrwi = new JTextField();
		txtGrupaKrwi.setEditable(false);
		txtGrupaKrwi.setText("Grupa krwi");
		txtGrupaKrwi.setColumns(10);

		splitPane_2 = new JSplitPane();

		numer_karty = new JFormattedTextField(NumberFormat.getNumberInstance());
		numer_karty.setColumns(10);
		numer_karty.setName("numer_karty");
		numer_karty.setToolTipText("liczba");

		nr_ksiazeczki_zdrowia = new JTextField();
		nr_ksiazeczki_zdrowia.setColumns(10);
		nr_ksiazeczki_zdrowia.setName("nr_ksiazeczki_zdrowia");
		nr_ksiazeczki_zdrowia.setToolTipText("numer/rok");

		nazwisko = new JTextField();
		nazwisko.setColumns(10);
		nazwisko.setName("nazwisko");
		nazwisko.setToolTipText("pole nie mo¿e byæ puste");

		poradnia = new JTextField();
		poradnia.setColumns(10);
		poradnia.setName("poradnia");

		imie = new JTextField();
		imie.setColumns(10);
		imie.setName("imie");
		imie.setToolTipText("pole nie mo¿e byæ puste");

		pesel = new JFormattedTextField(NumberFormat.getIntegerInstance());
		pesel.setColumns(10);
		pesel.setName("pesel");
		pesel.setToolTipText("11 cyfr");
		
		PropertyChangeListener l = new PropertyChangeListener() {

	        @Override
	        public void propertyChange(PropertyChangeEvent evt) {
	            String text = evt.getNewValue() != null ? evt.getNewValue().toString() : "";
	            if (evt.getNewValue().toString().charAt(9)%2 == 0) {
	            plec.setSelectedItem("¯");
	            } else plec.setSelectedItem("M");
	        }
	    };
	    pesel.addPropertyChangeListener("value", l);

		wiek = new JTextField();
		wiek.setText("0");
		wiek.setEditable(false);
		wiek.setColumns(10);
		
		adres = new JTextField();
		adres.setColumns(10);
		adres.setName("adres");
		adres.setToolTipText("pole nie mo¿e byæ puste");

		plec = new JComboBox();
		plec.setModel(new DefaultComboBoxModel(new String[] { "-", "M", "\u017B" }));
		plec.setToolTipText("");
		plec.setName("plec");

		oddzial_nfz = new JComboBox();
		oddzial_nfz.setEditable(true);
		oddzial_nfz.setModel(new DefaultComboBoxModel(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16" }));
		oddzial_nfz.setMaximumRowCount(16);
		oddzial_nfz.setName("oddzial_nfz");

		grupa_krwi = new JComboBox();
		grupa_krwi.setMaximumRowCount(4);
		grupa_krwi.setModel(new DefaultComboBoxModel(new String[] { "-", "0", "A", "B", "AB" }));
		grupa_krwi.setName("grupa");

		tn = new JComboBox();
		tn.addItem("T");
		tn.addItem("N");

		JSplitPane splitPane = new JSplitPane();
		splitPane_1 = new JSplitPane();

		samoplacacy = new JRadioButton("samop\u0142ac\u0105cy");
		splitPane_1.setLeftComponent(samoplacacy);

		bezplatnie = new JRadioButton("leczony bezp\u0142atnie");
		splitPane_1.setRightComponent(bezplatnie);
		splitPane_1.setName("ubezpieczenie");
		splitPane.setName("ubezpieczenie");

		rhplus = new JRadioButton("Rh+");
		rhminus = new JRadioButton("Rh-");
		rH = new ButtonGroup();
		rH.add(rhplus);
		rH.add(rhminus);

		JRadioButton czynny = new JRadioButton("czynny");
		JRadioButton bierny = new JRadioButton("bierny");
		ubezp = new ButtonGroup();
		ubezp.add(czynny);
		ubezp.add(bierny);
		ubezp.add(samoplacacy);
		ubezp.add(bezplatnie);

		picker = new JXDatePicker();
		picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		picker.setDate(new Date());
		picker.getMonthView().setUpperBound(new Date());
		picker.getEditor().setEditable(false);
		PropertyChangeListener listener = new PropertyChangeListener() {
		     public void propertyChange(PropertyChangeEvent e) {
		         if ("date".equals(e.getPropertyName())) {
		        	 wiek.setText(String.valueOf(calculateAge(picker.getDate())));
		         }
		     }
		 };
		 picker.addPropertyChangeListener(listener);


		datePicker = new JXDatePicker();
		datePicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		datePicker.setDate(new Date());
		datePicker.getMonthView().setUpperBound(new Date());
		datePicker.getEditor().setEditable(false);

		panel_2 = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");

		JPanel panel_3 = new JPanel();
		panel_3.add(picker);

		panel_4 = new JPanel();
		panel_4.add(datePicker);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Data", "Wywiad: objawy, rozpoznanie, leczenie, uwagi", "Nr statyst. choroby",
						"Pierwsze zachorowanie? T/N", "Niezdolno\u015B\u0107 do pracy OD",
						"Niezdolno\u015B\u0107 do pracy DO" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Object.class, Object.class, Object.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(0).setMinWidth(70);
		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(700);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setMinWidth(105);
		table.getColumnModel().getColumn(2).setMaxWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setMinWidth(160);
		table.getColumnModel().getColumn(3).setMaxWidth(160);
		table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(tn));
		table.getColumnModel().getColumn(4).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setMinWidth(140);
		table.getColumnModel().getColumn(4).setMaxWidth(140);
		table.getColumnModel().getColumn(5).setPreferredWidth(140);
		table.getColumnModel().getColumn(5).setMinWidth(140);
		table.getColumnModel().getColumn(5).setMaxWidth(140);
		
				JScrollPane scrollPane_1 = new JScrollPane();
				
						komunikaty = new JXLabel("");
						komunikaty.setLineWrap(true);
						scrollPane_1.setViewportView(komunikaty);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNowyPlik, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNowyPlik, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnOtwrzPlik, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnZapiszPlik, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnZapiszPdf, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(609, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOtwrzPlik, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(btnZapiszPlik, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(btnZapiszPdf, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtUbezpieczony, Alignment.LEADING)
										.addComponent(splitPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtNieubezpieczony).addComponent(splitPane_1,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
												.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 250,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addGap(92)
												.addComponent(btnDodajWiersz)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnUsuWiersz)
												.addPreferredGap(ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
												.addComponent(btnKasujRh).addGap(14))))
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel
												.createSequentialGroup().addContainerGap().addGroup(gl_panel
														.createParallelGroup(Alignment.LEADING)
														.addComponent(txtDataUr, GroupLayout.DEFAULT_SIZE, 161,
																Short.MAX_VALUE)
														.addComponent(txtAdres, GroupLayout.DEFAULT_SIZE, 161,
																Short.MAX_VALUE)
														.addComponent(
																txtNazwisko, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(
														adres, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 547,
														Short.MAX_VALUE)
														.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
																.createParallelGroup(Alignment.TRAILING)
																.addComponent(panel_3, Alignment.LEADING,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(nazwisko, GroupLayout.DEFAULT_SIZE, 260,
																		Short.MAX_VALUE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_panel
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(txtImi, GroupLayout.DEFAULT_SIZE,
																				74, Short.MAX_VALUE)
																		.addComponent(txtPesel,
																				GroupLayout.DEFAULT_SIZE, 74,
																				Short.MAX_VALUE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_panel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(pesel, GroupLayout.PREFERRED_SIZE,
																				201, GroupLayout.PREFERRED_SIZE)
																		.addComponent(imie, GroupLayout.DEFAULT_SIZE,
																				201, Short.MAX_VALUE)))))
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel.createSequentialGroup().addGap(135)
																.addComponent(txtPoradni, GroupLayout.PREFERRED_SIZE,
																		63, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(poradnia, GroupLayout.DEFAULT_SIZE, 373,
																		Short.MAX_VALUE)
																.addGap(57))
														.addGroup(gl_panel.createSequentialGroup().addGap(157)
																.addComponent(txtHistoriaChoroby,
																		GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
																.addGap(81)))
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(txtDataZarejest)
														.addComponent(txtNrKsZdrowia, Alignment.TRAILING)
														.addGroup(gl_panel.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtNrKarty)))
												.addGap(4)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(numer_karty, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
										.addComponent(nr_ksiazeczki_zdrowia, 0, 0, Short.MAX_VALUE)
										.addComponent(panel_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(txtPe, 0, 0, Short.MAX_VALUE)
														.addComponent(txtWiek, 0, 0, Short.MAX_VALUE)
														.addComponent(txtOddziaNfz, GroupLayout.DEFAULT_SIZE, 66,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(plec, 0, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(oddzial_nfz, Alignment.TRAILING, 0,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(wiek, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))))))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(5)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNrKarty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHistoriaChoroby, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(numer_karty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(poradnia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPoradni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDataZarejest, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nr_ksiazeczki_zdrowia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNrKsZdrowia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNazwisko, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(nazwisko, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtImi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(imie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(plec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtDataUr, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(pesel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(wiek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWiek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(txtPesel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAdres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(adres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOddziaNfz, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(oddzial_nfz, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(panel_2, 0, 0, Short.MAX_VALUE)
						.addComponent(txtUbezpieczony, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNieubezpieczony, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
						.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(splitPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnKasujRh))
						.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnDodajWiersz)
								.addComponent(btnUsuWiersz)))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE).addContainerGap()));

		scrollPane.setViewportView(table);

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(txtGrupaKrwi, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addGap(14).addComponent(grupa_krwi, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(splitPane_2, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(splitPane_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtGrupaKrwi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(grupa_krwi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		splitPane_2.setLeftComponent(rhplus);

		splitPane_2.setRightComponent(rhminus);
		panel_2.setLayout(gl_panel_2);

		splitPane.setLeftComponent(czynny);

		splitPane.setRightComponent(bierny);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		// AKCJE DLA PRZYCISKOW

		btnNowyPlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearAll();
				clearMistakes();
				komunikaty.setText("");
				btnZapiszPdf.setEnabled(false);
			}
		});

		// otwarcie pliku
		btnOtwrzPlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				komunikaty.setText("");
				//clearAll();
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(Formularz.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					filename = c.getSelectedFile().getName();
					dir = c.getCurrentDirectory().toString();
					String name = dir + '\\' + filename;

			//	String name = "C:/Users/slimak989/Desktop/dokcyf/hch1.xml";
					if (!openXMLFile(name)) {
						komunikaty.setText("WYBRANO NIEPOPRAWNY XML");
						komunikaty.setForeground(Color.red);
						clearAll();
					} else {
						imie.setText(historiaChoroby.pacjent.imie);
						nazwisko.setText(historiaChoroby.pacjent.nazwisko);
						adres.setText(historiaChoroby.pacjent.adres);
						poradnia.setText(historiaChoroby.poradnia);
						numer_karty.setValue(historiaChoroby.numerKarty);
						if (null != historiaChoroby.pacjent.ubezpieczenie.ubezpieczonyStatus) {
							oddzial_nfz.setSelectedIndex(
									historiaChoroby.pacjent.ubezpieczenie.ubezpieczonyStatus.oddzialNfz);
						} else
							oddzial_nfz.setSelectedItem("-");
						pesel.setValue(historiaChoroby.pacjent.pesel);
						// data_urodzenia.setText(String.valueOf(historiaChoroby.pacjent.dataUrodzenia));
						picker.setDate((historiaChoroby.pacjent.dataUrodzenia).toGregorianCalendar().getTime());
						//wiek.setText(String.valueOf(calculateAge((historiaChoroby.pacjent.dataUrodzenia).toGregorianCalendar().getTime())));
						plec.setSelectedItem(historiaChoroby.pacjent.plec);
						datePicker.setDate((historiaChoroby.pacjent.dataRejestracji).toGregorianCalendar().getTime());
						// data_zarejestrowania.setText(String.valueOf(historiaChoroby.pacjent.dataRejestracji));
						if (historiaChoroby.pacjent.krew != null) {
							if (historiaChoroby.pacjent.krew.rh == "+") {
								rhplus.setSelected(true);
							} else {
								rhminus.setSelected(true);
							}

							grupa_krwi.setSelectedItem(historiaChoroby.pacjent.krew.grupa);
						} else {
							grupa_krwi.setSelectedItem("-");
							rH.clearSelection();
						}
						nr_ksiazeczki_zdrowia.setText(historiaChoroby.pacjent.nrKsiazeczkiZdrowia);

						if ("samop³ac¹cy".equals(historiaChoroby.pacjent.ubezpieczenie.nieubezpieczonyStatus))
							samoplacacy.setSelected(true);
						else if ("leczony bezp³atnie"
								.equals(historiaChoroby.pacjent.ubezpieczenie.nieubezpieczonyStatus))
							bezplatnie.setSelected(true);
						else if ("czynny".equals(historiaChoroby.pacjent.ubezpieczenie.ubezpieczonyStatus.value))
							czynny.setSelected(true);
						else
							bierny.setSelected(true);

						if (null != historiaChoroby.historia.getChoroba()) {
							int numberOfIllness = historiaChoroby.historia.choroba.size();
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							for (int i = 0; i < numberOfIllness; i++) {
								model.addRow(new Object[] { "", "", "", "", "", "" });
								table.getModel().setValueAt(historiaChoroby.historia.choroba.get(i).data, i, 0);
								table.getModel().setValueAt(historiaChoroby.historia.choroba.get(i).wywiad, i, 1);
								table.getModel().setValueAt(historiaChoroby.historia.choroba.get(i).numerChoroby, i, 2);
								table.getModel()
										.setValueAt(historiaChoroby.historia.choroba.get(i).pierwszeZachorowanie, i, 3);
								table.getModel().setValueAt(historiaChoroby.historia.choroba.get(i).niezdolnoscPraca.od,
										i, 4);
								table.getModel()
										.setValueAt(historiaChoroby.historia.choroba.get(i).niezdolnoscPraca._do, i, 5);
							}
						}
					}
				}
			}
		});

		// Zapis pliku
		btnZapiszPlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearMistakes();
				komunikaty.setText("");
				JFileChooser c = new JFileChooser();
				int rVal = c.showSaveDialog(Formularz.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					filename = c.getSelectedFile().getName();
					if (!filename.endsWith(".xml")) {
						filename = filename.concat(".xml");
					}
					dir = c.getCurrentDirectory().toString();
					String name = dir + '\\' + filename;
					System.out.print(name);
					ObjectFactory of = new ObjectFactory();

					TypPacjent pacjent = of.createTypPacjent();
					pacjent.setNazwisko(nazwisko.getText());
					pacjent.setImie(imie.getText());
					pacjent.setPlec((String) plec.getSelectedItem());
					pacjent.setAdres(adres.getText());
					try {
						GregorianCalendar calendar = new GregorianCalendar();
						calendar.setTimeInMillis(datePicker.getDate().getTime());
						XMLGregorianCalendar xmlcalendar = DatatypeFactory.newInstance()
								.newXMLGregorianCalendar(calendar);
						xmlcalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
						pacjent.setDataRejestracji(xmlcalendar);
						calendar.setTimeInMillis(picker.getDate().getTime());
						xmlcalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
						xmlcalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
						pacjent.setDataUrodzenia(xmlcalendar);

					} catch (DatatypeConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pacjent.setNrKsiazeczkiZdrowia(nr_ksiazeczki_zdrowia.getText());

					if (pesel.getText().length() != 0) {
						// pacjent.setPesel(new BigInteger(pesel.getText()));
						pacjent.setPesel(new BigInteger(pesel.getValue().toString()));
					}

					TypUbezpieczenie ubezpieczenie = of.createTypUbezpieczenie();
					if (czynny.isSelected()) {
						TypTStatus typT = of.createTypTStatus();
						typT.setOddzialNfz(oddzial_nfz.getSelectedIndex());
						typT.setValue("czynny");
						ubezpieczenie.setUbezpieczonyStatus(typT);
					} else if (bierny.isSelected()) {
						TypTStatus typT = of.createTypTStatus();
						typT.setOddzialNfz(oddzial_nfz.getSelectedIndex());
						typT.setValue("bierny");
						ubezpieczenie.setUbezpieczonyStatus(typT);
					} else if (samoplacacy.isSelected()) {
						ubezpieczenie.setNieubezpieczonyStatus("samop³ac¹cy");
					} else if (bezplatnie.isSelected()) {
						ubezpieczenie.setNieubezpieczonyStatus("leczony bezp³atnie");
					}

					if (((rhminus.isSelected() || rhplus.isSelected()) && (grupa_krwi.getSelectedItem().equals("-")))
							|| ((!rhminus.isSelected()) && (!rhplus.isSelected())
									&& (!grupa_krwi.getSelectedItem().equals("-")))) {
						panel_2.setBackground(Color.red);
						komunikaty.setForeground(Color.red);
						komunikaty.setText("Grupa krwi niekompletna - nie zosta³a zapisana.\n");
					} else if ((rhminus.isSelected() || rhplus.isSelected())
							&& !(grupa_krwi.getSelectedItem().equals("-"))) {
						TypKrew krew = of.createTypKrew();
						krew.setGrupa(grupa_krwi.getSelectedItem().toString());
						if (rhplus.isSelected()) {
							krew.setRh("+");
						} else
							krew.setRh("-");
						pacjent.setKrew(krew);
					}
					pacjent.setUbezpieczenie(ubezpieczenie);
				//	TyphistoriaChoroby historia = of.createTyphistoriaChoroby();
					historiaChoroby = of.createTyphistoriaChoroby();
					TypHistoria hist = of.createTypHistoria();
					if (numer_karty.getText().length() != 0) {
						// historia.setNumerKarty(Integer.valueOf(numer_karty.getText()));

						historiaChoroby.setNumerKarty(Integer.valueOf(numer_karty.getValue().toString()));
					}
					historiaChoroby.setPoradnia(poradnia.getText());
					historiaChoroby.setPacjent(pacjent);

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int numberOfRows = model.getRowCount();
					for (int i = 0; i < numberOfRows; i++) {
						if (i == 0) {
							hist.choroba = new LinkedList();
						}
						boolean correct = true;
						boolean isNiezdolny = true;
						// zwaliduj czy sa pola poprawne, jak nie to nic dalej nie rob
						if (null == table.getValueAt(i, 0)
								|| !table.getValueAt(i, 0).toString().matches("(\\d){4}-(\\d){2}-(\\d){2}")) {
							correct = false;
							komunikaty.setText(komunikaty.getText() + "B³êdna wartoœæ w tabeli w kol. 1, wiersz "
									+ (i + 1) + "\n");
							komunikaty.setForeground(Color.red);
						}
						if (null == table.getValueAt(i, 4) && null == table.getValueAt(i, 5)) {
							isNiezdolny = false;

						} else {
							if (null == table.getValueAt(i, 4)
									|| !table.getValueAt(i, 4).toString().matches("(\\d){4}-(\\d){2}-(\\d){2}")) {
								correct = false;
								komunikaty.setText(komunikaty.getText() + "B³êdna wartoœæ w tabeli w kol. 5, wiersz "
										+ (i + 1) + "\n");
								komunikaty.setForeground(Color.red);
							}

							if (null == table.getValueAt(i, 5) || !table.getValueAt(i, 5).toString().matches("(\\d){4}-(\\d){2}-(\\d){2}")) {
									correct = false;
									komunikaty.setText(komunikaty.getText()
											+ "B³êdna wartoœæ w tabeli w kol. 6, wiersz " + (i + 1) + "\n");
									komunikaty.setForeground(Color.red);
							}
						}
						if (null == table.getValueAt(i, 2) || !table.getValueAt(i, 2).toString().matches("[A-Z](\\d){2}.(\\d)")) {
							correct = false;
							komunikaty.setText(komunikaty.getText() + "B³êdna wartoœæ w tabeli w kol. 3, wiersz "
									+ (i + 1) + "\n");
							komunikaty.setForeground(Color.red);
						}
						if (correct) {
							TypHistoria.Choroba chorobaEl = new TypHistoria.Choroba();
							chorobaEl.setWywiad((String) table.getValueAt(i, 1));
							TypNiezdolnoscPraca niezd = of.createTypNiezdolnoscPraca();
							try {
								XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
										.newXMLGregorianCalendar(table.getValueAt(i, 0).toString());
								chorobaEl.setData(xmlGregorianCalendar);
								if (isNiezdolny) {
								xmlGregorianCalendar = DatatypeFactory.newInstance()
										.newXMLGregorianCalendar(table.getValueAt(i, 4).toString());
								niezd.setOd(xmlGregorianCalendar);
								xmlGregorianCalendar = DatatypeFactory.newInstance()
										.newXMLGregorianCalendar(table.getValueAt(i, 5).toString());
								niezd.setDo(xmlGregorianCalendar);
								}
							} catch (DatatypeConfigurationException e) {
								e.printStackTrace();
							}

							chorobaEl.setNiezdolnoscPraca(niezd);
							chorobaEl.setNumerChoroby((String) table.getValueAt(i, 2));
							chorobaEl.setPierwszeZachorowanie((String) table.getValueAt(i, 3));

							hist.choroba.add(chorobaEl);
						}
					}
					historiaChoroby.setHistoria(hist);

					JAXBElement root = of.createHistoriaChoroby(historiaChoroby);
					LinkedList<String> bledy = saveXMLFile(name, root);
					for (String s : bledy) {
						for (Component comp : panel.getComponents()) {
							if (s.equals(comp.getName())) {
								comp.setBackground(Color.red);

								if (comp instanceof javax.swing.JSplitPane) {
									Component[] comps = ((javax.swing.JSplitPane) comp).getComponents();
									comps[0].setBackground(Color.red);
									comps[1].setBackground(Color.red);
									comps[2].setBackground(Color.red);
								}
							}
						}
					}
					if (adres.getText().length() == 0) {
						adres.setBackground(Color.red);
					}
					if (poradnia.getText().length() == 0) {
						poradnia.setBackground(Color.red);
					}

				}

			}

		});
		
		btnZapiszPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser c = new JFileChooser();
				int rVal = c.showSaveDialog(Formularz.this);
				String name = "";
				if (rVal == JFileChooser.APPROVE_OPTION) {
					filename = c.getSelectedFile().getName();
					if (!filename.endsWith(".pdf")) {
						filename = filename.concat(".pdf");
					}
					dir = c.getCurrentDirectory().toString();
					name = dir + '\\' + filename;
				}
				
			//	String name = "C:/Users/slimak989/Desktop/dokcyf/aa.pdf";
				PdfCreator pdfcreator = new PdfCreator();
				pdfcreator.createHistoriaChorobyDocument(historiaChoroby, name, wiek.getText());
				
			}
		});

		btnKasujRh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rH.clearSelection();
			}
		});

		btnDodajWiersz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				model.addRow(new Object[] { sdf.format(new Date()), "", "", "T", sdf.format(new Date()),
						sdf.format(new Date()) });
			}
		});

		btnUsuWiersz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numRows = table.getSelectedRows().length;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < numRows; i++) {

					model.removeRow(table.getSelectedRow());
				}
			}
		});

	}

	private void clearAll() {
		imie.setText("");
		nazwisko.setText("");
		adres.setText("");
		poradnia.setText("");
		numer_karty.setText(String.valueOf(""));
		oddzial_nfz.setSelectedItem("-");
		pesel.setText("");
		wiek.setText("0");
		picker.setDate(new Date());
		plec.setSelectedItem("-");
		datePicker.setDate(new Date());
		grupa_krwi.setSelectedItem("-");
		rH.clearSelection();
		ubezp.clearSelection();
		nr_ksiazeczki_zdrowia.setText("");
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		clearMistakes();
	}

	private void clearMistakes() {
		panel_2.setBackground(null);
		for (Component comp : panel.getComponents()) {
			if (comp instanceof javax.swing.JSplitPane) {
				Component[] comps = ((javax.swing.JSplitPane) comp).getComponents();
				comps[0].setBackground(Color.white);
				comps[1].setBackground(Color.white);
				comps[2].setBackground(Color.white);
			}
			if (comp.getBackground().equals(Color.red))
				comp.setBackground(Color.white);

		}
	}

	private boolean openXMLFile(String name) {
		clearAll();
		JAXBContext jc;
		TyphistoriaChoroby historia = null;
		try {
			jc = JAXBContext.newInstance(ObjectFactory.class);
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File("schema.xsd"));

			Unmarshaller unmarshaller = jc.createUnmarshaller();
			unmarshaller.setSchema(schema);
			unmarshaller.setEventHandler(new ValidationEventHandler() {
				@Override
				public boolean handleEvent(ValidationEvent event) {
					switch (event.getSeverity()) {
					case ValidationEvent.WARNING:
					case ValidationEvent.ERROR:
					case ValidationEvent.FATAL_ERROR:

						break;
					default:
						System.out.println("Invalid configuration validation event!");
						break;
					}
					return false;
				}
			});
			JAXBElement<TyphistoriaChoroby> root;

			root = (JAXBElement<TyphistoriaChoroby>) unmarshaller.unmarshal(new File(name));

			historiaChoroby = root.getValue();
			btnZapiszPdf.setEnabled(true);

		} catch (JAXBException e) {
			return false;
		} catch (SAXException e) {
			return false;
		}
		return true;
	}

	private LinkedList<String> saveXMLFile(String name, JAXBElement root) {
		LinkedList<String> blednePola = new LinkedList<String>();
		try {
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File("schema.xsd"));
			File file = new File(name);

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			JAXBSource source = new JAXBSource(jaxbContext, root);

			javax.xml.validation.Validator validator = schema.newValidator();
			final java.util.List<SAXParseException> exceptions = new LinkedList<SAXParseException>();
			validator.setErrorHandler(new ErrorHandler() {
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					exceptions.add(exception);
				}

				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					exceptions.add(exception);
				}

				@Override
				public void error(SAXParseException exception) throws SAXException {
					exceptions.add(exception);
				}
			});

			validator.validate(source);
			for (Exception e : exceptions) {
				int pozycja = e.getMessage().toLowerCase().indexOf(" attribute ");

				if (pozycja != -1) {
					String s = e.getMessage().substring(pozycja);
					String[] pociete = s.split("'");
					blednePola.add(pociete[1]);
				} else {
					pozycja = e.getMessage().indexOf("element");
					if (pozycja != -1) {
						String s = e.getMessage().substring(pozycja);
						String[] pociete = s.split("'");
						blednePola.add(pociete[1]);
					}
				}
			}
			if (exceptions.isEmpty()) {
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				jaxbMarshaller.marshal(root, file);
				jaxbMarshaller.marshal(root, System.out);
				String s = komunikaty.getText();
				komunikaty.setText("Zapisano plik\n" + s);
				btnZapiszPdf.setEnabled(true);
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blednePola;

	}
	
	private int calculateAge(Date birthDate) {
		Date dateNow = new Date();
		long timeBetween = dateNow.getTime() - birthDate.getTime();
		double yearsBetween = timeBetween / 3.15576e+10;
		int age = (int) Math.floor(yearsBetween);
		return age;
	}
}
