{%- let name = self.config.project.name_upper_camel() %}
{%- let package_class_name = name|fmt("{}Package") %}
{%- let module_class_name = name|fmt("{}Module") %}
// Generated by uniffi-bindgen-react-native
package {{ self.config.project.android.package_name }};

import androidx.annotation.Nullable;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.TurboReactPackage;

import java.util.HashMap;
import java.util.Map;

public class {{ package_class_name }} extends TurboReactPackage {

  @Nullable
  @Override
  public NativeModule getModule(String name, ReactApplicationContext reactContext) {
    if (name.equals({{ module_class_name }}.NAME)) {
      return new {{ module_class_name }}(reactContext);
    } else {
      return null;
    }
  }

  @Override
  public ReactModuleInfoProvider getReactModuleInfoProvider() {
    return () -> {
      final Map<String, ReactModuleInfo> moduleInfos = new HashMap<>();
      moduleInfos.put(
              {{ module_class_name }}.NAME,
              new ReactModuleInfo(
                      {{ module_class_name }}.NAME,
                      {{ module_class_name }}.NAME,
                      false, // canOverrideExistingModule
                      false, // needsEagerInit
                      true, // hasConstants
                      false, // isCxxModule
                      true // isTurboModule
      ));
      return moduleInfos;
    };
  }
}
