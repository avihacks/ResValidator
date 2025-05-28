# Keep Spring Boot entry point
-keep class com.reqvalidator.ResValidator.ResValidatorApplication {
    public static void main(java.lang.String[]);
}

# Keep Spring-related classes and their members
-keep @org.springframework.stereotype.Component class * { *; }
-keep @org.springframework.context.annotation.Configuration class * { *; }
-keep @org.springframework.web.bind.annotation.RestController class * { *; }

# Preserve fields injected by Spring
-keepclassmembers class * {
    @org.springframework.beans.factory.annotation.Autowired <fields>;
    @org.springframework.beans.factory.annotation.Value <fields>;
}
-ignorewarnings
-dontoptimize
-dontpreverify
-verbose

# Suppress warnings for Spring classes
-dontwarn org.springframework.**
-dontnote org.springframework.**

# Preserve methods annotated with Spring REST annotations
-keepclassmembers class * {
    @org.springframework.web.bind.annotation.RequestMapping *;
    @org.springframework.web.bind.annotation.GetMapping *;
    @org.springframework.web.bind.annotation.PostMapping *;
    @org.springframework.web.bind.annotation.PutMapping *;
    @org.springframework.web.bind.annotation.DeleteMapping *;
    @org.springframework.web.bind.annotation.PatchMapping *;
}

# Keep Jackson annotations and common methods
-keepclassmembers class * {
    @com.fasterxml.jackson.annotation.JsonProperty *;
    @com.fasterxml.jackson.annotation.JsonIgnore *;
    @com.fasterxml.jackson.annotation.JsonCreator *;
   
}

# General keep for Spring and Jackson classes
-keep class org.springframework.** { *; }
-keep class com.fasterxml.jackson.** { *; }
-dontwarn org.springframework.**
-dontwarn com.fasterxml.jackson.**

# Preserve annotations and inner class details
-keepattributes *Annotation*, Signature, InnerClasses, EnclosingMethod
