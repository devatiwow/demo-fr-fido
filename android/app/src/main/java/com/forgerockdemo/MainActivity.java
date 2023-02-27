package com.forgerockdemo;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import org.forgerock.android.auth.Node;
import org.forgerock.android.auth.NodeListener;
import android.content.Intent;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "forgerockdemo";
  }
  public static Promise reactNativePromise;

  public void centralizedLogin() {
    CentralLoginActivity.reactNativePromise = reactNativePromise;
    Intent intent = new Intent(this, CentralLoginActivity.class);
    startActivity(intent);
  }

  public void idpSignOn(ReactApplicationContext context, Node node, NodeListener listener) {
    IdpSignOnActivity.reactNativePromise = reactNativePromise;
    IdpSignOnActivity.currentNode = node;
    IdpSignOnActivity.listener = listener;
    Intent intent = new Intent(this, IdpSignOnActivity.class);
    startActivity(intent);
  }

  public void webAuthNRegister(ReactApplicationContext context, Node node, NodeListener listener) {
    WebAuthNRegisterActivity.reactNativePromise = reactNativePromise;
    WebAuthNRegisterActivity.currentNode = node;
    WebAuthNRegisterActivity.listener = listener;
    Intent intent = new Intent(this, WebAuthNRegisterActivity.class);
    startActivity(intent);
  }

  public void webAuthNSignOn(ReactApplicationContext context, Node node, NodeListener listener) {
    WebAuthNSignOnActivity.reactNativePromise = reactNativePromise;
    WebAuthNSignOnActivity.currentNode = node;
    WebAuthNSignOnActivity.listener = listener;
    Intent intent = new Intent(this, WebAuthNSignOnActivity.class);
    startActivity(intent);
  }

  /**
   * Returns the instance of the {@link ReactActivityDelegate}. Here we use a util class {@link
   * DefaultReactActivityDelegate} which allows you to easily enable Fabric and Concurrent React
   * (aka React 18) with two boolean flags.
   */
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new DefaultReactActivityDelegate(
        this,
        getMainComponentName(),
        // If you opted-in for the New Architecture, we enable the Fabric Renderer.
        DefaultNewArchitectureEntryPoint.getFabricEnabled(), // fabricEnabled
        // If you opted-in for the New Architecture, we enable Concurrent React (i.e. React 18).
        DefaultNewArchitectureEntryPoint.getConcurrentReactEnabled() // concurrentRootEnabled
        );
  }
}
