package proto

import (
	"github.com/bazelbuild/intellij/examples/go/with_proto/proto/embedded"
	"time"
)

// Time translation functions.

func CreateMessage() embedded.Message {
	return embedded.Message{}
}

func ToProtoTime(t time.Time) Time {
	return Time{Value: t.Format(time.RFC3339Nano)}
}
