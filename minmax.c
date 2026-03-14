#include<stdio.h>
void minmax(int arr[],int low,int high,int result[])
{
    int mid;
    if(low==high)
    {
        result[0]=arr[low];
        result[1]=arr[low];

    }
    else if(low==high-1)
    {
        if(arr[low]<arr[high])
        {
            result[0]=arr[low];
            result[1]=arr[high];

        }
        else{
            result[0]=arr[high];
            result[1]=arr[low];
        }
    }
    else{
        mid=low+(high-low)/2;
        int left[2],right[2];
        minmax(arr,low,mid,left);
        minmax(arr,mid+1,high,right);
        if(left[0]<right[0])
        {
            result[0]=left[0];
        }
        else{
            result[0]=right[0];
        }
        if(left[1]>right[1])
        {
            result[1]=left[1];
        }
        else{
            result[1]=right[1];
        }
    }
}
int main()
{
    int arr[]={7,2,9,4,1,6};
    int result[2];
    minmax(arr,0,5,result);
    printf("The minimum value is: %d\n",result[0]);
    printf("The maximum value is: %d\n",result[1]);
    return 0;

}