# ToastMatcherCode (Android Unit Testing)
**CustomToastMatcher in both Java and Kotlin**

Toast Message testing is a little bit difficult. Because it appears on a different window(not in our activity's decor view)

I have shared the code of `CustomToastMatcher`.

You will use this matcher, in this way.

```
onView(withText(MainActivity.buildToastMessage(EXPECTED_NAME)))
    .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
    .check(matches(isDisplayed()));
    
```


But remember that test will successful only on that **device** having **API <30**
