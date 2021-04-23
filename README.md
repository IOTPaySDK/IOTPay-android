# IOTPay-Android
###### IOTPay sdk for Android
<br />    


IOTPay-Android is a sdk called in merchant app to collect consumer's credit/debit card information.
<br /> 
1 Embed a credit entry GUI to collect consumer’s credit/debit card information:
<br /> card number, holder name, expiry date, CVV/CVC
<br /> 
2 provide add card, payment methods

<br />      




## Step 1: Install 
<br /> 
(1) copy IOTPayAndroidCredit-release.aar to app/libs
<br /> 
(2) add followings in app/build.gradle
<br /> <br /> 
```
repositories {
	flatDir {
		dirs 'libs'
   	}
}
dependencies {
	compile(name:'IOTPayAndroidCredit-release',ext:'aar')
}

```

<br />      

## Step 2: Setup View<br /> 
Embed IOTPay credit entry GUI into a ViewGroup in your app.<br /> <br /> 

IOTCardInfoView IOTCardInfoView(ViewGroup viewGroup, int creditCardStyle)<br />
creditCardStyle:<br /> 
 Triple Lines: <br /> 
   (int)IOTPayConstants.TripleLine.label<br /> 
 ![alt text](https://github.com/zhongzeyu/IOTPay-android/blob/master/triple.png ) 


Single Line:<br /> 
   (int)IOTPayConstants.SingleLine.label<br /> 
 ![alt text](https://github.com/zhongzeyu/IOTPay-android/blob/master/single.png ) 
 
<br /> 
<br /> 
###example:<br /> 
<br />
 IOTCardInfoView iotCardInfoView;<br />
 <br />
 ...<br />
 iotCardInfoView = IOTPayService.IOTCardInfoView(myViewGroup,(int)IOTPayConstants.TripleLine.label);<br />

<br /> 
<br /> 


<br />      

## Step 3: Send the Request<br /> 
pay or add card<br /> 

IOTPayService.sendRequest(String secureId, Object layoutType, IOTCardInfoView creditForm,IOTPayCallback iotPayCallback);
<br />
###layoutType:<br /> 

  IOTPayConfig.OneTimePayment<br /> 
  
  IOTPayConfig.AddCard<br /> 


Example:<br /> 
(2.1) pay:<br /> 
 //Make sure secureID for payment has been retrieved from context<br /> 
 try{<br />
IOTPayService.sendRequest(secureId,IOTPayConfig.OneTimePayment, iotCardInfoView,new IOTPayCallback(){<br />
        public void onResultIOTPay(String result) {<br />
            //please process result in your own way, ex: showMsg("Payment Result:" + result);<br />
        }<br />
      });<br />
  }catch (Exception e){<br />
      //showMsg("Error:" + e.getMessage());<br />
  }<br />

(2.2) Add card: binding the card to a consumer<br /> 
  //Make sure secureID for card adding has been retrieved from context<br /> 
  try{<br />
IOTPayService.sendRequest(secureId,IOTPayConfig.AddCard,iotCardInfoView,new IOTPayCallback(){<br />
        public void onResultIOTPay(String result) {<br />
          //please process result in your own way, ex: showMsg("Payment Result:" + result);<br />
        }<br />
      });<br />
   }catch (Exception e){<br />
       //showMsg("Error:" + e.getMessage());<br />
  }<br />

