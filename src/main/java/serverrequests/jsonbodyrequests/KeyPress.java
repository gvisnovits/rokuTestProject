package serverrequests.jsonbodyrequests;

public class KeyPress {

	private String button;
	private String[] button_sequence;
	private String[] buttons_delays;

	public KeyPress(String button) {
		this.button = button;
	}

	public KeyPress(String button, String[] buttons_delays) {
		this.button = button;
		this.buttons_delays = buttons_delays;
	}

	public KeyPress(String[] button_sequence) {
		this.button_sequence = button_sequence;
	}

	public KeyPress(String[] button_sequence, String[] buttons_delays) {
		this.button_sequence = button_sequence;
		this.buttons_delays = buttons_delays;
	}

}
