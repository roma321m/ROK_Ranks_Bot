package view;

public interface PopUps_View {
	// Input Error pop up message
	void popInputError(String msg);

	// Information pop up message
	void popSuccessfully(String title, String Header, String content);
}
