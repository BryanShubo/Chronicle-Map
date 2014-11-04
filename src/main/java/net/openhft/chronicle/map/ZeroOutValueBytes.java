/*
 * Copyright 2014 Higher Frequency Trading http://www.higherfrequencytrading.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.chronicle.map;

import net.openhft.lang.io.Bytes;

final class ZeroOutValueBytes<K, V> implements PrepareValueBytes<K, V> {
    private static final long serialVersionUID = 0L;
    private final long valueSize;

    ZeroOutValueBytes(long valueSize) {
        this.valueSize = valueSize;
    }

    @Override
    public void prepare(Bytes bytes, K key) {
        long pos = bytes.position();
        bytes.zeroOut(pos, pos + valueSize, true);
        bytes.skip(valueSize);
    }
}
