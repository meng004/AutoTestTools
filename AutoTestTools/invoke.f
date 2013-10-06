      program x 
!------ 
      common /GVAR/gravity
      real time
!------ 
      gravity=9.8
      time=10.0
!------ 
      print *,'callfunc=',func1(time) 
      open(unit=2, file='OutputFile.txt')  
      write(2,*) 'save data succeed!!'   
      end