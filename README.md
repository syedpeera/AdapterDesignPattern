# AdapterDesignPattern

Overview:
The Adapter Design Pattern is a structural design pattern and is also known as the Wrapper Design Pattern. This design pattern acts as a bridge between two different interfaces. It can convert the interface of a class, to make it compatible with a client who is expecting a different interface, without changing the source code of the class.

Scope of this Article:
1. The need and usage of Adapter Design Pattern
2. Understanding how does an Adapter Design Pattern work.
3. Understanding how to implement the Adapter Design Pattern and write the psuedocode.
4. Implementing the psuedocode in Java and C++.
5. Discussing the Pros and Cons of Adapter Design Pattern.
6. Discussing the similarities of Adapter Design Pattern with other design pattern.
7. Some general FAQs.

When Will We Need Adapter Design Pattern?
As said earlier, an adapter design pattern acts as a link between two different interfaces. Lets us take a few examples to understand this:

1. Like we have a card reader adapter which acts as a link between our computer and memory card.
2. Another example will be a charging adapter that acts as a link between a device and the charging port.
Now let's take an example and try to see how can we implement an adapter design pattern to solve that problem.

Let us say we have an image showing application that can show only jpeg images, but we want to use an advanced image application that is capable of showing png and jpg files too. So we can use Adapter Design Pattern here to act as a link between these two different interfaces.

How Does the Adapter Design Pattern Work?
We have an ImageViewer interface and a concrete class named GalleryApp which is implementing the ImageViewer interface. GalleryApp can show jpeg files by default.

Let us say we have another interface named AdvancedImageViewer and concrete classes implementing this interface. These classes can show png and jpg files by default.

Now we want our GalleryApp class to be able to show png and jpg files without changing the source code of the ImageViewer interface.

So here we will use an adapter design pattern to solve this problem.

Implementation of Adapter Design Pattern:
So we can use an Adapter design pattern to achieve this. We will create a ImageAdapter which implements ImageViewer and uses a AdvancedImageViewer object to show the desired image format.

Our Gallery application will use the ImageAdapter and simply pass the desired image format without worrying about which class can show what image format.

Pseudo-Code of Adapter Design Pattern:

ImageViewer inteface
  void show(String imageFormat, String fileName)

AdvancedImageViewer interface
  void showPng(String fileName)
  void showJpg(String fileName)

PngShower class : implements AdvancedImageViewer interface
  void showPng(String fileName)
  void showJpg(String fileName)

JpgShower class: implements AdvancedImageViewer interface
  void showPng(String fileName)
  void showJpg(String fileName)

ImageAdapter adapter class: implements ImageViewer interface
  AdvancedImageViewer advancedImageViewer
  ImageAdapter(String imageFormat) : constructor
  void show(String imageFormat, String fileName)

GalleryApp class: implements ImageViewer interface
  ImageAdapter imageAdapter
  void show(String imageFormat, String fileName)


Code Implementation of Adapter Design Pattern in Java:

Step 1:
Create interfaces for ImageViewer and AdvancedImageViewer.

ImageViewer.java


public interface ImageViewer {
   public void show(String imageFormat, String fileName);
}

AdvancedImageViewer.java

public interface AdvancedImageViewer {	
   public void showPng(String fileName);
   public void showJpg(String fileName);
}

Step 2:

Create concrete classes implementing the AdvancedImageViewer interface.

PngShower.java

public class PngShower implements AdvancedImageViewer{
   @Override
   public void showPng(String fileName) {
      System.out.println("Showing png file. Name: "+ fileName);		
   }

   @Override
   public void showJpg(String fileName) {
      //do nothing
   }
}

JpgShower.java

public class JpgShower implements AdvancedImageViewer{

   @Override
   public void showPng(String fileName) {
      //do nothing
   }

   @Override
   public void showJpg(String fileName) {
      System.out.println("Showing jpg file. Name: "+ fileName);		
   }
}

Step 3:

Create adapter class implementing the ImageViewer interface.

ImageAdapter.java

public class ImageAdapter implements ImageViewer {

   AdvancedImageViewer advancedImageViewer;

   public ImageAdapter(String imageFormat){
   
      if(imageFormat.equalsIgnoreCase("png") ){
         advancedImageViewer = new PngShower();			
      }else if (imageFormat.equalsIgnoreCase("jpg")){
         advancedImageViewer = new JpgShower();
      }	
   }

   @Override
   public void show(String imageFormat, String fileName) {
   
      if(imageFormat.equalsIgnoreCase("png")){
         advancedImageViewer.showPng(fileName);
      }
      else if(imageFormat.equalsIgnoreCase("jpg")){
         advancedImageViewer.showJpg(fileName);
      }
   }
}

Step 4:

Create a concrete class implementing the ImageViewer interface.

GalleryApp.java

public class GalleryApp implements ImageViewer {
    
   ImageAdapter imageAdapter; 

   @Override
   public void show(String imageFormat, String fileName) {
       
      //inbuilt support to show jpeg image files
      if(imageFormat.equalsIgnoreCase("jpeg")){
         System.out.println("Showing jpeg file. Name: " + fileName);			
      } 
      //imageAdapter is providing support to show other file formats
      else if(imageFormat.equalsIgnoreCase("png") || imageFormat.equalsIgnoreCase("jpg")){
         imageAdapter = new ImageAdapter(imageFormat);
         imageAdapter.play(imageFormat, fileName);
      }
      else{
         System.out.println("Invalid image. " + imageFormat + " format not supported");
      }
   }
    
}

Step 5:

Use the Gallery to show different types of image formats.

AdapterPatternDemo.java

public class AdapterPatternDemo {
   public static void main(String[] args) {
       
      GalleryApp gallery = new GalleryApp();

      gallery.show("jpeg", "naruto.jpeg");
      gallery.show("png", "sasuke.png");
      gallery.show("jpg", "jiraya.jpg");
      gallery.show("gif", "sakura.gif");
   }
}

Step 6:

Verify the output.

Showing jpeg file. Name: naruto.jpeg
Showing png file. Name: sasuke.png
Showing jpg file. Name: jiraya.jpg
Invalid image. gif format not supported
As we can see that we have successfully used an adapter design pattern to the GalleryApp which even though implemented only the ImageViewer interface can show image formats that are supported by the AdvancedImageViewer interface using our ImageAdapter.


Pros and Cons of Adapter Design Pattern:

Pros:
1. Separation of Concern: We can separate the interface or data conversion code from the main business logic part of the code.
2. Independence of Code: We can implement and use the various adapters without breaking the existing client or main code.

Cons:
1. We have to write a lot of code and it can decrease the efficiency. Sometimes it will be simpler to just change the code of a particular interface.

Relations of Adapter Design Pattern with Other Patterns:

1. Adapter is commonly used with an existing interface to make some otherwise-incompatible classes work together consistently. On the other hand, Bridge is usually designed up-front, letting you develop parts of an application independently of each other.

2. Decorator supports recursive composition, which isn’t possible when you use Adapter. In addition, Adapter changes the interface of an existing object, while the Decorator enhances an object without changing its interface.

3. Adapter provides a different interface to the wrapped object, Decorator provides it with an enhanced interface and Proxy provides it with the same interface.

4. Facade defines a new interface for existing objects, whereas Adapter tries to make the existing interface usable. Adapter usually wraps just one object, while Facade works with an entire subsystem of objects.

5. Bridge, State, Strategy (and to some degree Adapter) have very similar structures. Indeed, all of these patterns are based on composition, which is delegating work to other objects. However, they all solve different problems. A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other developers the problem the pattern solves.

FAQs about Adapter Design Pattern:
1. Which design problems does the adapter design pattern solve?
The adapter design pattern solves problems like: Reusing a class that does not have an interface that a client requires and making classes that have incompatible interfaces work together.

2. What are the two variations of the adapter design pattern?
Two Variants of Adapter Pattern: Class Adapter and Object Adapter.

3. What is the difference betwwen Class Adapter and Object Adapter?
Class Adapter as the name suggests can only wrap classes and not interfaces. It uses inheritance to achieve this.
Object Adapter can wrap both classes and objects and it uses composition to do this.
