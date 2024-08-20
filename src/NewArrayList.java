import jdk.internal.util.ArraysSupport;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Класс расширяет возможности стандартного класса Array, и позволяет добавлять объекты в любое место массива,
 * расширять его размеры и удалять элементы из массива, выделять под массивы.
 */
public class NewArrayList <E> implements NewList <E>, Iterator <E>{
    /**
     * Пустой массив
     */
    private static final Object [] EMPTY_OBJECTS = {};
    /**
     * Стандартный размер массива
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Инстанс класса хранящий данные массива
     */
    transient Object [] objects;
    /**
     * Размер массива
     */
    private int size;

    /**
     * Конструктор для создания объекта класса заданного размера
     * @param capacity - заданный размер массива     *
     * @exception IllegalArgumentException исключение
     */
    public  NewArrayList ( int capacity) {
        if (capacity > 0){
            this.objects = new Object[capacity];
        } else if (capacity == 0) {
            this.objects = EMPTY_OBJECTS;
        }else {
            throw new IllegalArgumentException ("Illegal capacity "+ capacity);
        }
    }

    /**
     * Конструктор для создания объекта класса без параметров (DEFAULT)
     */

    public NewArrayList() {
       this.objects = new Object[0];
    }

    /**
     *
     * @return размер заданного массива
     */
    public int size (){
        return size;
    }

    /**
     * Уменьшает массив до размера хранимых в нем нулевых элементов.
     * Метод нужен для уменьшения занимаемой массивом памяти.
     */
    public void trimToSize(){
        if (size < objects.length){
            objects = (size == 0)
                    ? EMPTY_OBJECTS
                    : Arrays.copyOf(objects, size);
        }
    }

    /**
     * Внутренний метод который расширяет массив
     * @param m минимальный размеер массива
     * @return расширенный массив
     */
    private Object [] grow(int m){
        int oldCapacity = objects.length;
        if (oldCapacity >0){
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    m - oldCapacity,
                    oldCapacity >> 1);
            return objects = Arrays.copyOf(objects,newCapacity);
        }else {
            return objects = new Object[Math.max(DEFAULT_CAPACITY, m)];
        }
    }

    /**
     * Внутренний метод для добавления элемента массива
     * @param e - элемент массива
     * @param o - объект массива
     * @param s - размер массива
     */
    private void add (E e, Object [] o, int s){
        if (s == o.length){
            o = grow(s+1);
        }
        objects[s] = e;
        size = s + 1;
    }

    /**
     * Метод добавляет элемент в конец массива
     * @param e - элемент массива
     * @return возвращает true по завершению операции
     */
    public boolean add(E e) {
        add(e,objects,size);
        return true;
    }

    /**
     * Метод добавляет элемент в массив по индексу.
     * @param i - индекс массива
     * @param e - элемент массива
     */
    public void add (int i, E e){
        final int s = size;
        Object [] object = this.objects;
        if (s == object.length){
            object = grow(s+1);
        }
        System.arraycopy(object, i, object,i + 1,s - i);
        object[i] = e;
        size = s + 1;
    }

    /**
     * Удаляет элемент массива по индексу
     * @param i индекс
     * @throws IndexOutOfBoundsException если индекс вне границ (меньше 0 или меньше размера массива)
     */
    public void remove (int i) throws IndexOutOfBoundsException {
        if(i < 0 || i > size) throw new IndexOutOfBoundsException ();
        Object [] object = objects;
        int newSize = size - 1;
        if (newSize > i){
            System.arraycopy(object,i+1,object,i,newSize);
        }
        object [size=newSize] = null;
    }
    /**
     * Метод выдает элемент массива по его индексу
     * @param i индекс массива
     * @return элемент массива
     * @throws IndexOutOfBoundsException
     */
    public E get (int i) {
        if(i < 0 || i > size) throw new IndexOutOfBoundsException ();
        return (E) objects[i];
    }

    /**
     * Метод записывает новое значение в массив по его индексу
     *
     * @param index индекс массива
     * @param e     элемент массива
     * @return Элемент массива
     */
    public E set(int index, E e){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException ();
        E oldValue = (E) objects [index];
        objects[index] = e;
        return oldValue;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
