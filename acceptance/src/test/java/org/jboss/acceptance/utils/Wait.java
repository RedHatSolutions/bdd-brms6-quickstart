/*
* JBoss, Home of Professional Open Source
* Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
* contributors by the @authors tag. See the copyright.txt in the
* distribution for a full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.jboss.acceptance.utils;

public class Wait{
	  public static boolean For(int timeoutInSeconds, int intervalInSeconds, ToHappen toHappen, String errorMessage) {
	    long start=System.currentTimeMillis();
	    long end=start+(timeoutInSeconds*1000);
	    boolean timeout=false;
	    while(!toHappen.hasHappened() && !timeout){
	      try{
	        Thread.sleep((intervalInSeconds*1000));
	      }catch(InterruptedException ignor){}
//	      System.out.println("[Wait] - waiting... ["+((end-System.currentTimeMillis())/1000)+"s]");
	      timeout=System.currentTimeMillis()>end;
	      if (timeout) System.out.println("timed out waiting: "+errorMessage);
	    }
	    if (timeout) return false;
	    return true;
	  }
	  public static boolean For(int timeoutInSeconds, ToHappen toHappen, String errorMessage) {
	    return For(timeoutInSeconds, 1, toHappen, errorMessage);
	  }

    public static boolean For(int timeoutInSeconds, ToHappen toHappen) {
      return For(timeoutInSeconds, 1, toHappen, "dont know what we were waiting for");
    }
}