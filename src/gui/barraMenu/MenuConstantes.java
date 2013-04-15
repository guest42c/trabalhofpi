package gui.barraMenu;

public interface MenuConstantes {
	
	//JMenu
	String FILE = "File", EDIT = "Edit", OPERATIONS = "Operations", HELP = "Help";

	//JMenuItem
	String OPEN ="Open", SAVE_ORIGINAL_IMAGE = "Save the Original Image", EXIT = "Exit", 
	       SAVE_MODIFIED_IMAGE = "Save the Modified Image",
	       SHOW_ORIGINAL_IMAGE = "Show the Original Image",
	       SHOW_MODIFIED_IMAGE = "Show Modified Image", COPY = "Copy",
	       HORIZONTAL_FLIP = "Horizontal Flip", VERTICAL_FLIP = "Vertical Flip", 
	       GRAY_SCALE = "Gray Scale", QUANTIZATION = "Quantization";
	
	//JOptionPane
	String QUANTIZATION_MESSAGE = "Number of tones:", ERROR_TITLE = "Error",
	NUMBER_FORMAT_EXCPETION_MESSAGE = "Please, digit only a number in the field.";
}
