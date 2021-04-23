# IOTPay-Android
###### IOTPay sdk for Android
<br />    


IOTPay-Android is a sdk called in merchant app to collect consumer's credit/debit card information.
<br /> 
1 Inject a credit form to collect consumer’s credit/debit card information:
<br /> card number, holder name, expiry date, CVV/CVC
<br /> 
2 provide add card, payment methods


<br />      




## Step 1: Install 
(1) copy IOTPayAndroidCredit-release.aar to app/libs
(2) add followings in app/build.gradle
repositories {
flatDir {
	dirs 'libs' 
}
} ...
dependencies {
 ...
	compile(name:'IOTPayAndroidCredit-release',ext:'aar')

...
}



<br />      

## Step 2: Setup View
Inject IOTPay credit form into a ViewGroup in your app.
IOTCardInfoView IOTCardInfoView(ViewGroup viewGroup, int creditCardStyle)
creditCardStyle:
 Triple Lines: 
   (int)IOTPayConstants.TripleLine.label
 


Single Line:
   (int)IOTPayConstants.SingleLine.label
 

example:
 IOTCardInfoView iotCardInfoView;
 
 ...
 
 iotCardInfoView = IOTPayService.IOTCardInfoView(myViewGroup,(int)IOTPayConstants.TripleLine.label);




<br />      

## Step 3: Send the Request
pay or add card
IOTPayService.sendRequest(String secureId, Object layoutType, IOTCardInfoView creditForm,IOTPayCallback iotPayCallback);
layoutType:

  IOTPayConfig.OneTimePayment
  
  IOTPayConfig.AddCard
Example:
(2.1) pay:
 //Make sure secureID for payment has been retrieved from context

 try{

      IOTPayService.sendRequest(secureId,IOTPayConfig.OneTimePayment, iotCardInfoView,new IOTPayCallback(){

        public void onResultIOTPay(String result) {

            //please process result in your own way, ex: showMsg("Payment Result:" + result);

        }


      });

  }catch (Exception e){

      //showMsg("Error:" + e.getMessage());

  }
(2.2) Add card: binding the card to a consumer
  //Make sure secureID for card adding has been retrieved from context

  try{

      IOTPayService.sendRequest(secureId,IOTPayConfig.AddCard,iotCardInfoView,new IOTPayCallback(){

        public void onResultIOTPay(String result) { //result

          //please process result in your own way, ex: showMsg("Payment Result:" + result);

        }

      });

   }catch (Exception e){

       //showMsg("Error:" + e.getMessage());

  }

		

