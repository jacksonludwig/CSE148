package p1ObjectSerialization;

// ABSTRACTION example
public class PersonBag {
	private Person[] arr;
	private int nOfElements; // counter -- How many items are currently in the bag (NOT SIZE OF THE ARRAY)

	public PersonBag(int maxSize) {
		arr = new Person[maxSize];
		nOfElements = 0;
	}

	// user will not have to worry about indices because it is dealt with HERE (hence abstraction).
	public void insert(Person person) {
		arr[nOfElements++] = person; 
		// nOfElements++;
	}
	
	public Person deletePersonById(String id) {
		int i = -1;
		for(i = 0; i < nOfElements; i++) {
			if(arr[i].getId().equals(id)) {
				break;
			}
		}
		if(i == nOfElements) {
			return null;
		}
		else {
			Person temp = arr[i]; // person to be deleted
			for(int j = i; j < nOfElements; j++) { // shifts array
				arr[j] = arr[j + 1];
			}
			nOfElements--;
			
			return temp;
		}
			
	}

	public Person findPersonById(String id) {
		for(int i = 0; i < nOfElements; i++) {
			if(arr[i].getId().equals(id)) 
				return arr[i];
		}
		return null;
	}
	
	public void display() {
		for(int i = 0; i < nOfElements; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
}
