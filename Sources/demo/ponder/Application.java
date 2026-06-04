package demo.ponder;

import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.appserver.WORequestHandler;
import com.webobjects.foundation.NSTimeZone;

import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.navigation.ERXNavigationManager;

public class Application extends ERXApplication {
	private static Logger LOG = LoggerFactory.getLogger(Application.class);

	static {
		// Set default time zones
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		NSTimeZone.setDefaultTimeZone(NSTimeZone.getGMT());
	}

	public static void main(final String argv[]) {
		ERXApplication.main(argv, Application.class);
	}

	@Override
	public void didFinishLaunching() {
		/* ** put your post initialization code in here ** */
		LOG.info("Welcome to ponderapp!");
	}

	@Override
	public void finishInitialization() {
		// Initialize the navigation manager
		ERXNavigationManager.manager().configureNavigation();

		// Set the default request handler to the direct action request handler
		final String key = directActionRequestHandlerKey();
		final WORequestHandler handler = requestHandlerForKey(key);
		setDefaultRequestHandler(handler);
	}

}
