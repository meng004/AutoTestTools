!     -----source code-------


        function func1(time)
                common gravity
                real time,func1
                func1=gravity*time**2/2;
                return
        end function func1

        subroutine swap(x,y)
                integer x,y
                x=XOR(x,y)
                y=XOR(x,y)
                x=XOR(x,y)
                return
        end subroutine swap
                
