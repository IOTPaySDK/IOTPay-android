# IOTPay-Android
###### IOTPay sdk for Android
<br />    


IOTPay-Android is a sdk called in merchant app to collect consumer's credit/debit card information.
<br /> 
[For the whole business picture please refer the ](https://github.com/IOTPaySDK/IOTPay-iOS/blob/main/README.md)
1 Embed a credit entry GUI into a ViewGroup to collect consumer’s credit/debit card information:
<br /> card number, holder name, expiry date, CVV/CVC
<br /> 
2 provide add card, payment methods
![alt text](https://github.com/zhongzeyu/IOTPay-android/blob/master/demo.png ) 
<br />      




## Step 1: Install 
<br /> 
(1) copy IOTPayAndroidCredit-release.aar to app/libs
<br /> 
(2) add followings in app/build.gradle
<br /> <br /> 

```java
repositories {
	flatDir {
		dirs 'libs'
   	}
}


dependencies {
   ...
	compile(name:'IOTPayAndroidCredit-release',ext:'aar')
   ...
}
```


## Step 2: Setup View
Embed IOTPay credit entry GUI into a ViewGroup in your app.
```java
IOTCardInfoView IOTCardInfoView(ViewGroup viewGroup, int creditCardStyle)
```


- creditCardStyle:

 Triple Lines:
```java

   (int)IOTPayConstants.TripleLine.label
```

 ![alt text](https://github.com/zhongzeyu/IOTPay-android/blob/master/triple.png ) 


Single Line:
```java

   (int)IOTPayConstants.SingleLine.label
```

 ![alt text](https://github.com/zhongzeyu/IOTPay-android/blob/master/single.png ) 
 

- Example:

```java
 IOTCardInfoView iotCardInfoView;
 ...
 iotCardInfoView = IOTPayService.IOTCardInfoView(myViewGroup,(int)IOTPayConstants.TripleLine.label);
```


## Step 3: Send the Request
pay or add card
```java
IOTPayService.sendRequest(String secureId, Object layoutType, IOTCardInfoView creditForm,IOTPayCallback iotPayCallback);
```

- layoutType:
```java
  IOTPayConfig.OneTimePayment  
  IOTPayConfig.AddCard
```

- Example:

(2.1) pay:

 //Make sure secureID for payment has been retrieved from context
```java
 try{
IOTPayService.sendRequest(secureId,IOTPayConfig.OneTimePayment, iotCardInfoView,new IOTPayCallback(){
        public void onResultIOTPay(String result) {
            //please process result in your own way, ex: showMsg("Payment Result:" + result);
        }
      });
  }catch (Exception e){
      //showMsg("Error:" + e.getMessage());
  }
```

(2.2) Add card: binding the card to a consumer

  //Make sure secureID for card adding has been retrieved from context
```java
  try{
IOTPayService.sendRequest(secureId,IOTPayConfig.AddCard,iotCardInfoView,new IOTPayCallback(){
        public void onResultIOTPay(String result) {
          //please process result in your own way, ex: showMsg("Payment Result:" + result);
        }
      });
   }catch (Exception e){
       //showMsg("Error:" + e.getMessage());
  }
```

#Reference: 
[How to get SecureID](https://github.com/IOTPaySDK/IOTPay-iOS/blob/main/README.md)
