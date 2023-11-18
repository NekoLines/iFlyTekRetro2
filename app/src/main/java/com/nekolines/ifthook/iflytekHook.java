package com.nekolines.ifthook;


import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import java.security.Key;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XposedHelpers;
public class iflytekHook implements  IXposedHookLoadPackage {

        public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {

            if(lpparam.packageName.equals("com.iflytek.inputmethod.zte")) {

                XposedHelpers.findAndHookMethod("com.iflytek.common.util.log.Logging", lpparam.classLoader,"isDebugLogging", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param)
                            throws Throwable {
                        boolean result = true;
                        param.setResult(result);
                    }
                });

                XposedHelpers.findAndHookMethod("app.bfs", lpparam.classLoader,"a", KeyEvent.class,new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param)
                            throws Throwable {

                        Log.e("app.bfs", "input[0] " + param.args[0]);

                        KeyEvent event = (KeyEvent) param.args[0];

                        if((int)event.getKeyCode()==KeyEvent.KEYCODE_F8){
                            KeyEvent rinput = new KeyEvent(event.getDownTime(),event.getEventTime(),event.getAction(),KeyEvent.KEYCODE_POUND,event.getRepeatCount(),event.getMetaState());
                            param.args[0]=rinput;
                        }

                        if((int)event.getKeyCode()==KeyEvent.KEYCODE_F9){
                            KeyEvent rinput = new KeyEvent(event.getDownTime(),event.getEventTime(),event.getAction(),KeyEvent.KEYCODE_STAR,event.getRepeatCount(),event.getMetaState());
                            param.args[0]=rinput;
                        }

                    }
                });
            }
        }

}
