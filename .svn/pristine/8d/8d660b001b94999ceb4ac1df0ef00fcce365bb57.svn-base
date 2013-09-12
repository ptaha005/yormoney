package com.codexsoft.yormoney.util;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        int index = pathname.getAbsolutePath().indexOf(".svn");

        if (index <= 0)
            return true;
        return false;
    }
}