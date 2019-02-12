package com.hashmap.excercise.chapter2;

import java.util.ArrayList;

/**
 * Compile the Network class. Note that the inner class file is named
 * Network$Member.class. Use the javap program to spy on the generated code. The
 * command
 * javap -private Classname
 * displays the methods and instance variables. Where do you see the reference to the enclosing
 * class? (In Linux/Mac OS X, you need to put a \ before the $ symbol when running javap.)
 */

public class NetworkQ14 {
    public class Member { // Member is an inner class of NetworkQ14

        private String name;
        private ArrayList<Member> friends;

        public Member(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }

        public void leave() {
            members.remove(this);
        }

    }
    private ArrayList<Member> members;

    public Member enroll(String name) {Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

}



