/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        //// replace the following statement with your code
        if(size == maxSize)
        {
            return false;
        }
        tracks[size] = track;
        size++;
        return true;
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    //// For an efficient implementation, use StringBuilder.
    public String toString() {
        //// replace the following statement with your code
        StringBuilder temptrack = new StringBuilder();
        temptrack.append("\n");
        for(int i=0; i< size; i++)
        {
            //temptrack = temptrack.append(tracks[i].getTitle()).append(tracks[i].getArtist()).append(tracks[i].getDuration()); //make a string that contain all the details we want to print
            if(tracks[i] != null)
            {
                temptrack.append(tracks[i].toString());
            }
            
            if( i+1 < size){
            temptrack.append("\n"); //make a new line for the next song
            }
        }

        return temptrack.toString();
    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() {
        //// replace this comment with your code
        if(size > 0)
        {   
            tracks[size-1] = null;
            size--;
        }

    }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() {
        //// replace the following statement with your code
        int totalDuration = 0;
        for(int i = 0 ; i < size; i++)
        {
            if(tracks[i] != null)
            {
                totalDuration += tracks[i].getDuration(); //get the duration of each song and add to the sum
            }
            
        }
        return totalDuration;
    }

    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) {
        //// replace the following statement with your code
        //Boolean flag = false;
        for(int i = 0; i < size ; i++)
        {
            if(((tracks[i] != null) && (tracks[i].getTitle().equals(title))))
            {
                return i;
            }
            if(tracks[i] == null)
            {
                return -1;
            }
        }
        return -1;
    }

    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track) {
        //// replace the following statement with your code
        if(size == maxSize || i > maxSize || i < 0)
        {
            return false;
        }
        Track[] temptracklist = new Track[maxSize];
        if ( i == size) //if they are equal so its more simple and we finish
        {
            tracks[i] = track;
            return true;
        }
        for(int k=0; k<i; k++)
        {
            temptracklist[k] = tracks[k]; //make a copy from the original playlist until the pointer is i-1
        }
        temptracklist[i] = track;
        
        for(int j =i+1; j< maxSize ; j++ )
        {
            temptracklist[j] = tracks[j-1]; // copy the rest of the array 
        }
        tracks = temptracklist;
        size++; //because we add one song to the playlist
        return true;
    }
     
    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i) {
        //// replace this comment with your code
        Boolean flag = ((size == 0)|| size == -1 || i < 0 || (i > size)) ; //if some of them is true than we dont want to act
        //Track[] temptrack = new Track[maxSize];
        if(!flag) //if everything is good than lets make a party of removing songs
        {
           /*  for(int j=0 ; j<i ; j++)
            {
                temptrack[j] = tracks[j]; //copy until the song we dont want
            }
            for (int k = i; k < maxSize;k++)
            {
                temptrack[k] = tracks[k+1];
            }
            */
            for (int j = i; j < size - 1; j++) {
                tracks[j] = tracks[j + 1]; // Shift tracks to fill the gap
            }
            tracks[size - 1] = null; // Set the last element to null
            size--;
        }

    }

    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, or the given index
     *  is negative or too big for this list, does nothing. */
    public void remove(String title) {
        //// replace this comment with your code
        int indexof = -1;
        if(size > 0)
        {
            for(int i=0; i<= maxSize; i++)
        {
            if(tracks[i].getTitle().equals(title))
            {
                indexof = i;
                break;
            }
        }
        if(indexof != -1)
        {
            remove(indexof); //after we find the indexof we can use the function above in order to remove 
        }
        }
        
    }

    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst() {
        //// replace this comment with your code
        /* 
        Track[] withoutFirstTrack = new Track[maxSize];
        if(size !=0)
        {
            for( int i = 1 ; i<= maxSize ; i++)
            {
                withoutFirstTrack[i-1] = tracks[i];
            }
            tracks = withoutFirstTrack;
        }*/
        if(size != 0) //not empty
        {
            remove(0);
        }

    }
    
    /** Adds all the tracks in the other list to the end of this list. 
     *  If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) {
        //// replace this comment with your code
        if((this.getSize() + other.getSize() <= maxSize))
        {
            for(int i = 0; i< (other.getSize()) ; i++) //start for the end of the first playlist
            {
                if(( size < maxSize))
                {
                    this.add(other.getTrack(i));
                    
                }
                
            }
            
        }
    }

    /** Returns the index in this list of the track that has the shortest duration,
     *  starting the search in location start. For example, if the durations are 
     *  7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the 
     *  minimum value (5) when starting the search from index 2.  
     *  If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) {
        //// replace the following statement with your code
        int min = tracks[start].getDuration();
        int minindex = start;
        if((start < 0) || (start > size-1))
        {
            return -1;
        }
        for(int i=minindex; i< maxSize; i++)
        {
            if(tracks[i] != null)
            {
                if(tracks[i].getDuration() < min)
                {
                    minindex = i;
                    min = tracks[i].getDuration();
                }
            }
        }
        
        return minindex;
    }

    /** Returns the title of the shortest track in this list. 
     *  If the list is empty, returns null. */
    public String titleOfShortestTrack() {
        return tracks[minIndex(0)].getTitle();
    }

    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() {
        // Uses the selection sort algorithm,  
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
        /*for(int i=0; i < maxSize ; i++)
        {   
            if(tracks[i] != null)
            {   
                Track temp = new Track(tracks[i].getTitle(), tracks[i].getArtist(),tracks[i].getDuration());
                tracks[i] = tracks[minIndex(i)];
                tracks[minIndex(i)] = temp;
            }
            
        }*/
        
         
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (tracks[j].getDuration() < tracks[minIndex].getDuration()) {
                    minIndex = j;
                }
            }
            // Swap tracks[i] and tracks[minIndex]
            Track temp = tracks[i];
            tracks[i] = tracks[minIndex];
            tracks[minIndex] = temp;
    }
    
}
}
