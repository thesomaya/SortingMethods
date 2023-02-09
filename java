import java.util.Random;
import java.util.Scanner;

class Node 
{
    public int key;
    Node left, right;
    
    public Node (int item)
    {
        key = item;
        left = right = null;
    }
    public int getKey () // returns the id number
    {
        return key;
    }
       
    public Node getRight () // returns the address of the right element
    {
        return right;
    }
    public Node getLeft () // returns the address of the left element
    {
        return left;
    }
        
    public void setKey (int d) // sets the id 
    {
        key = d;
    }
        
    public void setRight (Node r) // sets the address to the right element 
    {
        right = r;
    }
    public void setLeft (Node l) // sets the address to the left element 
    {
        left = l;
    }
    
}

class treeSort
{
    Node root;
    int n;
    int count;
    // Constructor
    public treeSort ()
    {
        root = null;
        n = 0;
        count = 0;
    }
    public int getCount()
    {
        return count;
    }
    
    public void insert (int d) 
    { // a function to insert new elements    
        
        Node temp = root;
        count += 2;
        if (root == null) // calls isEmpty function to check if the tree is empty 
        {
            root = new Node (d); // let root equal to the new element
            count += 2;
            return;
        }
        // else, if not empty
        Node pre = null; // declare pointer pre equal to null
        count += 2;
        while (temp != null) // while hasn't reached the end
        {
            count++;
            if (d > temp.getKey()) // if the ID of the new element is larger than temp id
            {
                pre = temp; // move pre to temp
                temp = temp.getRight(); // and let temp equal to the next element from the right 
                count += 2;
            }
            else if (d < temp.getKey()) // if the ID of the new element is smaller than temp id
            {
                count += 2;
                pre = temp; // move pre equal to temp
                temp = temp.getLeft(); // and let temp equal to the next element from the left 
            }
            else {
                System.out.println("This ID already exists.");
                count += 2;
                return;
            }
        } // end while loop
        // the pointer pre is now at the element where we're gonna place the new element
        temp = new Node (d); // create a new element, let temp points to
        count+=2;
        if (d > pre.getKey()) // if the id of the new element is greater than the id of pre
            pre.setRight(temp); // set the right of pre to temp (add the new element to the right)
        else // if the id is smaller
            pre.setLeft(temp);  // set the left of pre to temp (add the new element to the left)
    }
    
    // A function to do
    // inorder traversal of BST
    
    public void inorderSort(int [] arr)
    {
        n = 0;
        count += 2;
        inorderSort(root,arr);
    }
    public void inorderSort(Node temp, int [] arr)
    {
        count++;
        if (temp != null)
        {
            inorderSort(temp.getLeft(), arr);
            arr[n] = temp.getKey();
            n++;
            count += 4;
            inorderSort(temp.getRight(), arr);
        }
    }

}

public class Main
{
        public static int addValue (int [] x, int n)
        {
            Scanner s = new Scanner (System.in);
            System.out.println("Enter a value: ");
            int d = s.nextInt();
            boolean b = linearSearch(x,d,n);
            while (b == true || d < 400 || d > 1000)
            {
                System.out.println("Existing before, Enter another value: ");
                d = s.nextInt(); 
                b = linearSearch(x,d,n);
            }
            
            x[n] = d;
            return n+1;
        }
        
        public static int deleteValue(int [] x, int d, int n)
        {
            for (int i = 0; i < n; i++)
                if (x[i] == d)
                    {
                        x[i] = x[n-1];
                        n--;
                    }
                return n;
                
        }
        
        public static boolean linearSearch (int [] x, int d, int n)
        {
            for (int i = 0; i < n; i++)
                if (x[i] == d)
                    return true;
            return false;
        }
        
        public static void printArray (int [] x, int n)
        {
            System.out.println("\nPrint Values: ");
            for (int i = 0; i < n; i++)
            {
                if (i % 10 == 0)
                    System.out.println();
                System.out.print(x[i] + " ");
            }
        }
        public static int bubbleSort (int x [], int y [], int n)
        {
            int i,j,temp;
            int count = 0; // initiate variable count 
            // copy the array 
            for (i = 0; i < n; i++) 
                y[i] = x[i];
            boolean Sorted = false;
            for (i = 0; i < n-1 && Sorted == false; i++)
            {
                Sorted = true;
                for (j = 0; j < n-1-i; j++)
                {
                    count++;
                    if ( y[j] > y[j+1] )
                    {
                        temp = y[j];
                        y[j] = y[j+1];
                        y[j+1] = temp;
                        Sorted = false;
                    }
                }
            }
            return count;
        }
        
        public static int selectionSort(int x [], int z [], int n)
        {
            int count = 1;
            for (int k = 0; k < n; k++) // copy the array 
                z[k] = x[k];
            count += n;
            for (int i = 0; i < n-1; i++)
            {
                // Find the minimum element in unsorted array
                count += 2;
                int min = i;
                count ++;
                for (int j = i+1; j < n; j++)
                {
                    count+=2;
                    count++;
                    if (z[j] < z[min])
                    {
                        min = j;
                        count++;
                    }
                }
                // Swap the found minimum element with the first element
                int temp = z[min];
                z[min] = z[i];
                z[i] = temp;
                count +=3;
            }
            count++;
            return count;
        }
        
        public static int insertionSort(int a [], int d [], int n)
        {
            int count = 1;
            for (int k = 0; k < n; k++) // copy the array
                d[k] = a[k];
            count += n;
            for (int i = 1; i < n; ++i)
            {
                count+=2;
                int key = d[i]; 
                int j = i-1;
                count+=2;
                count++;
                while (j >= 0 && d[j] > key)
                {
                    count+=2;
                    d[j+1] = d[j];
                    j = j - 1;
                }
                d[j+1] = key;
                count++;
            }
            count++;
            return count;
        }
        
        public static int quickSort(int e[], int low, int high)
        {
                
            int pivot = e[high]; 
            e[100] += 1;
            int i = (low-1); // index of smaller element
            e[100] += 1;
            
            for (int j=low; j<high; j++)
            {
                // If current element is smaller than pivot
                e[100] += 2;
                if (e[j] < pivot)
                {
                    i++;

                    int temp = e[i];
                    e[i] = e[j];
                    e[j] = temp;
                    e[100] += 4;
                }
            }
  
            // swap e[i+1] and e[high] (or pivot)
            int temp = e[i+1];
            e[i+1] = e[high];
            e[high] = temp;
            e[100] += 3;
            return i+1;
        }

        public static void qSort(int e[], int low, int high)
        {
            if (low < high)
            {
                int p = quickSort(e, low, high);
                
                qSort(e, low, p-1);
                qSort(e, p+1, high);
            }
        }
        

    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        arr[100] += 2;
        
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
        arr[100] += 2;
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        arr[100] += 3;
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        arr[100] += 3;
        
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
                arr[100] += 3;
            }
            else 
            {
                arr[k] = R[j];
                j++;
                arr[100] += 2;
            }
            k++;
            arr[100] += 1;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
            arr[100] += 4;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
            arr[100] += 4;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    public static void mSort(int arr[], int l, int r)
    {
        if (l < r) 
        {
            // Find the middle point
            int m = l + (r-l)/2;
  
            // Sort first and second halves
            mSort(arr, l, m);
            mSort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    public static void countingSort (int [] a, int [] h, int n)
    {
        for (int i = 0; i < n; i++)
        {
            h[a[i] - 400] = a[i];
            h[601] += 3;
        }
    }
    
    public static void main (String [] args)
    {
        Random r = new Random();
        
        int [] a = new int [100];
        int [] b = new int [100];
        int [] c = new int [100];
        int [] d = new int [100];
        int [] e = new int [101];
        int [] f = new int [101];
        int [] g = new int [100];
        int [] h = new int [602];
        int count;
        int i = 0;
        int t = -1;
        
        for (i = 0; i < 90; i++)
        {
            int x = 400 + r.nextInt(601);
            boolean y = linearSearch(a,x,i);
            if (y == true)
                i--;
            else
                a[i] = x;
        }
        
        for (i = 90; i < 100; i++)
            addValue(a, i);
        
        printArray(a,100);
        count = bubbleSort(a,b,100);
        System.out.println("\n\nBubble Sort - Steps = " + count);
        printArray(b,100);
        
        count = selectionSort(a,c,100);
        System.out.println("\n\nSelection Sort - Steps = " + count);
        printArray(c,100);
        
        count = insertionSort(a,d,100);
        System.out.println("\n\nInsertion Sort - Steps = " + count);
        printArray(d,100);
        
        for (i = 0; i < a.length; i++)
            e[i] = a[i];
        e[100] = 0;
        qSort(e,0,99);
        System.out.println("\n\nQuick Sort - Steps = " + e[100]);
        printArray(e,100);
        
        for (i = 0; i < a.length; i++)
            f[i] = a[i];
        f[100] = 0;
        mSort(f,0,99);
        System.out.println("\n\nMerge Sort - Steps = " + f[100]);
        printArray(f,100);
        
        treeSort o = new treeSort ();
        for (i = 0; i < a.length; i++)
            o.insert(a[i]);
        System.out.println();
        o.inorderSort(g);
        System.out.println("\n\nBS Tree Sort - Steps = " + o.getCount());
        printArray(g,100);
        
        h[601] = 0;
        countingSort(a,h,100);
        System.out.println("\n\nCounting Sort - Steps = " + h[601]);
        for (i = 0; i < 601; i++)
            if (h[i] != 0)
            {
                t++;
                if (t % 10 == 0)
                    System.out.println();
                System.out.print(h[i] + " ");
            }
                
        
    }
}
