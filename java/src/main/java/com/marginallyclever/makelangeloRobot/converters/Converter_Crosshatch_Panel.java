package com.marginallyclever.makelangeloRobot.converters;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.marginallyclever.makelangelo.SelectFloat;
import com.marginallyclever.makelangelo.Translator;

public class Converter_Crosshatch_Panel extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Converter_Crosshatch converter;
	
	SelectFloat intensityField;
	
	public Converter_Crosshatch_Panel(Converter_Crosshatch arg0) {
		this.converter=arg0;
		
		intensityField = new SelectFloat(converter.getIntensity());

		setLayout(new GridLayout(0,1));
		this.add(new JLabel(Translator.get("ConverterIntensity")));
		this.add(intensityField);
		
		intensityField.addPropertyChangeListener("value",this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		converter.setIntensity(((Number)intensityField.getValue()).floatValue());
		converter.reconvert();
	}
}
