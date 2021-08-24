# Sample MS Word file test

## Requirements and Support
In addition to Appium's general requirements:

1. Windows PC with Windows 10 or up
2. Ability to enter Administrator mode
3. Turned [developer mode](https://docs.microsoft.com/en-us/windows/uwp/get-started/enable-your-device-for-development) on.
4. Installed the latest version of [WinAppDriver](https://github.com/Microsoft/WinAppDriver/releases)
5. Word 2019

### Run tests on Windows

* Start `WinAppDriver`, ensure that you have started the app as an **administrator**
* Set correct `application.ms-word.store-dir` value in the `application.yml` file
* Start the tests by `mvn clean test` command