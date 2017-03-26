package com.ahmaddev.xshazamlite;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Module implements IXposedHookLoadPackage {
    public static String PACKAGE_NAME = "com.shazam.android.lite";

    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(PACKAGE_NAME))
            return;

        XposedBridge.log("Loaded app: " + lpparam.packageName);

        findAndHookMethod("com.shazam.android.lite.d.b", lpparam.classLoader, "h", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called before the clock was updated by the original method
                param.setResult(String.valueOf("01"));
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called after the clock was updated by the original method
                param.setResult(String.valueOf("01"));
            }
        });

        findAndHookMethod("com.shazam.android.lite.d.b", lpparam.classLoader, "b", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called before the clock was updated by the original method
                param.setResult(String.valueOf("in"));
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called after the clock was updated by the original method
                param.setResult(String.valueOf("in"));
            }
        });

        findAndHookMethod("com.shazam.android.lite.d.b", lpparam.classLoader, "g", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called before the clock was updated by the original method
                param.setResult(String.valueOf("404"));
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called after the clock was updated by the original method
                param.setResult(String.valueOf("404"));
            }
        });
    }
}