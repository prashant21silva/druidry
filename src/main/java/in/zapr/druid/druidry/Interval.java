/*
 * Copyright (c) 2017-present, Red Brick Lane Marketing Solutions Pvt. Ltd.
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package in.zapr.druid.druidry;

import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Interval {

    private final static String DRUID_INTERVAL_FORMAT = "%s/%s";

    private DateTime startTime;
    private DateTime endTime;

    public Interval(@NonNull DateTime startTime, @NonNull DateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @JsonValue
    private String getIntervalAsString() {
        return String.format(DRUID_INTERVAL_FORMAT, startTime.toDateTimeISO(), endTime.toDateTimeISO());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Interval)) {
            return false;
        }

        Interval other = (Interval)obj;
        if (this == other) {
            return true;
        }
        return new EqualsBuilder()
                .append(startTime, other.startTime)
                .append(endTime, other.endTime)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(startTime)
                .append(endTime)
                .toHashCode();
    }
}