# Obfuscate but retain Spring functionality

# Preserve all annotations (important for Spring, Jackson, etc.)
-keepattributes *Annotation*, Signature, InnerClasses, EnclosingMethod

# Keep Spring Boot main application class
-keepclassmembers class com.reqvalidator.ResValidator.ResValidatorApplication {
    public static void main(java.lang.String[]);
}
-keep class com.reqvalidator.ResValidator.ResValidatorApplication  { *; }

# Keep configuration classes
-keep @org.springframework.context.annotation.Configuration class * { *; }
-keep @org.springframework.stereotype.Component class * { *; }
-keep @org.springframework.web.bind.annotation.RestController class * { *; }

# Keep Spring Boot bean methods and injected fields
-keepclassmembers class * {
    @org.springframework.beans.factory.annotation.Autowired <fields>;
    @org.springframework.beans.factory.annotation.Value <fields>;
}

# Keep REST API methods
-keepclassmembers class * {
    @org.springframework.web.bind.annotation.* <methods>;
}

# Keep Jackson annotated fields
-keepclassmembers class * {
    @com.fasterxml.jackson.annotation.* <fields>;
}

# Keep classes used by reflection
-keep class org.springframework.** { *; }
-keep class com.fasterxml.jackson.** { *; }
-dontwarn org.springframework.**
-dontwarn com.fasterxml.jackson.**

# Optional: Remove debugging info, overload names
-dontusemixedcaseclassnames
-overloadaggressively

# Obfuscate using dictionary (optional)
-obfuscationdictionary obfuscation-dictionary.txt

# You can also add:
-printmapping mapping.txt  # To debug obfuscation
