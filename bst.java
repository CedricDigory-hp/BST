//binary search tree
#include<iostream>
using namespace std;
class node
{
	public:
		int key;
		node *left,*right;
};
class bst
{
	public:
		node* root=NULL;
		void inorder(node*);
		void preorder(node*);
		void postorder(node*);
		node* insert(node*,node*);
		node* deletenode(node*,int);
		node* deletekey(node*);
		int maxval(node*);
		int Search(node*,int);
};
int bst::Search(node* root, int k) 
{ 
    while (root != NULL) 
	{ 
        if (k > root->key) 
            root = root->right; 
        else if (k < root->key) 
            root = root->left; 
        else
            return 1; 
    } 
    return 0; 
} 
void bst::inorder(node* root)
{
	if(root!=NULL)
	{
		inorder(root->left);
		cout<<root->key<<" ";
		inorder(root->right);
	}
}
void bst::preorder(node* root)
{
	if(root!=NULL)
	{
		cout<<root->key<<" ";
		preorder(root->left);
		preorder(root->right);
	}
}
void bst::postorder(node* root)
{
	if(root!=NULL)
	{
		postorder(root->left);
		postorder(root->right);
		cout<<root->key<<" ";
	}
}
node* bst::insert(node* root,node* tmp)
{
	if(root==NULL)
	{
		root=tmp;
	}
	else
	{
		if(root->key > tmp->key)
		  root->left=insert(root->left,tmp);
		if(root->key < tmp->key)
		  root->right=insert(root->right,tmp);  	  
	}
	return root;
}
node* bst::deletenode(node *root,int k)
{
    if(root->key>k)
     root->left=deletenode(root->left,k);
    else if(root->key<k)
      root->right=deletenode(root->right,k);
    else
      root=deletekey(root);
    return root;   
}
node* BinarySearchTree :: deletekey(node *tmp)
{
    if(tmp->left==NULL&&tmp->right==NULL)
        return NULL;
    else if(tmp->left==NULL||tmp->right==NULL)
    {
        if(tmp->left==NULL)
            return tmp->right;
        else
            return tmp->left;
    }
    else
    {
        int k1=maxval(tmp->left);
        // int k1=minval(tmp->right);
        tmp->key=k1;
        tmp->left=deletenode(tmp->left,k1);
    }
}
int bst:: maxval(node *tmp)
{
    while(tmp->right!=NULL)
       tmp=tmp->right;
    return tmp->key;   
}
int main()
{
	int n,n1,n2,n3,search;
	node* tmp=NULL;
	bst b;
	while(n!=5)
	{
		cout<<"\n1.Insert 2.Delete 3.Print 4.Search 5.Exit\n";
		cin>>n;
		switch(n)
		{
			case 1:tmp=new node();
			       cout<<"Enter a value:\n";
			       cin>>tmp->key;
			       tmp->left=NULL;
			       tmp->right=NULL;
			       b.root=b.insert(b.root,tmp);
			       break;
			case 2:cout<<"Enter node value:\n";
			       cin>>n1;
				   b.root=b.deletenode(b.root,n1);
				   break;
			case 3:cout<<"\n1.Inorder 2.Preorder 3.Postorder\n";
			       cin>>n2;
				   switch(n2)
				   {
				   	case 1: b.inorder(b.root);
				   	       break;
				   	case 2: b.preorder(b.root);
				   	       break;
					case 3: b.postorder(b.root);
				   	       break;		         
				   	default:cout<<"\nInvalid option\n";       
					}	          
			       break;
			case 4:cout<<"enter an element to be searched:\n";
			       cin>>search;
			       if (b.Search(b.root, search)) 
        			cout << "found\n"; 
    				else
        			cout << "Not found\n"; 
				    break;      
			case 5:cout<<"\nEXIT\n";
			       break;
			default:cout<<"\nInvalid option\n";       
		}
	}
}
