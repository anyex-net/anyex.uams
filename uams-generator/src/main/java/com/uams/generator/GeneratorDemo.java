package com.uams.generator;

/**
 * GeneratorDemo Introduce
 * <p>File：GeneratorDemo.java </p>
 * <p>Title: GeneratorDemo </p>
 * <p>Description:GeneratorDemo </p>
 * <p>Copyright: Copyright (c) 17/6/16</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class GeneratorDemo
{
    public static void main(String[] args) throws Exception
    {
        GeneratorFile file = new GeneratorFile();
        file.generateCRUDByTables(new String[]{"Entrust","RealDeal"});
    }
}
