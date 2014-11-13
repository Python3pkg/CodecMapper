CodecMapper
===========

CodecMapper derives mapping files from Java Charsets which can be processed
by Python's gencodec.py.


Requirements
------------

To build and run CodecMapper, you need:

  1. Java 1.7 or later
  2. ant 1.8 or later, available from https://ant.apache.org/.

It migth also work with earlier versions but has not been tested.
  

Usage
-----

To build CodecMapper, run:

```sh
$ ant dist
```

To generate a mapping file for a specific codec, run for example:

```sh
$ java -jar dist/CodecMapper.jar iso-8859-15
```

The resulting mapping file is stored in `iso-8859-15.txt`. The generated mapping files
are located in the same folder and have names like
`iso-8859.15.mapping`.

To convert the mapping files to Python codecs, run

```sh
$ python .../cpython/Tools/unicode/gencodec.py .
```

To build the example EBCDIC mapping files, run:

```sh
$ ant ebcdic
```

To convert the mapping files into Python codes, you can also try:

```sh
$ ant gencodec
```

If this target fails, you might have to change the properties `python` and
`cpython` in `build.xml`.

Also note that target is somewhat clumsy as it also build codecs from
`build.xml`, `README.md` and so on. You can simply ignore them.


Source code
-----------

See https://github.com/roskakori/CodecMapper.


License
-------

Copyright (c) 2013-2014, Thomas Aglassinger
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice,
  this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
