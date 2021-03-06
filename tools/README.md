gencodec.py
-----------

`gencodec.py` is a script originally included with the source code
distribution of Python 3.2. It converts mappings produced by CodecMapper to a
Python source code implementing the respective codec. Unless the version
included with Python 3.3 and later, the generated codecs still work with Python
3.1 to 3.2.

Additionally, this version adds

```python
from __future__ import unicode_literals
```

to the generated codecs so they also work with Python 2.6+.

Nevertheless the tool itself requires Python 3 to run.

To download other versions of this tool, obtain the Python source code as
described in <https://www.python.org/downloads/source/> and browse the
`Tools/unicode` folder.
