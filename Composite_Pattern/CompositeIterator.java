package Composite_Pattern;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {

    MenuComponent menuComponent;
    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();  //創建一個可以裝反覆器的stack

    public CompositeIterator(Iterator<MenuComponent> iterator){
        stack.push(iterator);
    }
    @Override
    public boolean hasNext() {
        if(stack.empty()){                                  
            return false;
        }
        else{
            Iterator<MenuComponent> iterator = stack.peek(); //從堆疊最上層取出反覆器，看看是否還有下個元素
            if(!iterator.hasNext()){                         //沒有了，就將反覆器取出，然後遞迴
                stack.pop();
                return hasNext();
            }
            else{                                            //否，則表示還有下一個
                return true;
            }
        }
    }
    @Override
    public MenuComponent next() {
        if(hasNext()){
            Iterator<MenuComponent> iterator = stack.peek();
            menuComponent = iterator.next();
            if(menuComponent instanceof GunMenu){           //今天再游走的時候，如果元素是個菜單，就將他丟進stack中
                stack.push( (Iterator<MenuComponent>) menuComponent.createIterator());
                
            } 
            return menuComponent;
        }
        else{
            return null;
        }
    }
    
}
