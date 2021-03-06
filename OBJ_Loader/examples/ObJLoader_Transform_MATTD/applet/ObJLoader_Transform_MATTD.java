import processing.core.*; 
import processing.xml.*; 

import saito.objloader.*; 
import saito.objtools.*; 
import processing.opengl.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class ObJLoader_Transform_MATTD extends PApplet {






// declare that we need a OBJModel and we'll be calling it "model"
OBJModel model;
float rotX;
float rotY;

int direction = 1;


public void setup()
{
  size(600, 600, P3D);

  // making an object called "model" that is a new instance of OBJModel
  model = new OBJModel(this);

  // turning on the debug output (it's all the stuff that spews out in the black box down the bottom)
  model.enableDebug();

  // enableLocalTexture is usefull if you're modeling package uses absolute paths when pointing to the diffuse testure (like XSI)
  // see mtl file in data folder for example
  model.setTexturePathMode(OBJModel.ABSOLUTE);

  //setting the draw mode
  model.shapeMode(TRIANGLES);

//  model.disableMaterial();

  model.load("cube_sphere_test.obj");

  noStroke();
}

public void draw()
{
  background(128);
  lights();

  pushMatrix();
  translate(width/2, height/2, 0);
  rotateX(rotY);
  rotateY(rotX);
  scale(3);

  model.draw();
  popMatrix();
  
  for(int i = 0; i < model.getVertexCount(); i ++)
  {

    PVector v = model.getVertex(i);
    PVector n = model.getNormal(i);
    
    PVector tempn = new PVector(n.x, n.y, n.z);
    
    tempn.mult( direction );
        
    v.add(tempn);
    
  }
  
  if(frameCount % 20 == 0){
   direction = -direction; 
  }
}


public void mouseDragged()
{
  rotX += (mouseX - pmouseX) * 0.01f;
  rotY -= (mouseY - pmouseY) * 0.01f;
}



  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "ObJLoader_Transform_MATTD" });
  }
}
